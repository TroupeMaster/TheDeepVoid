package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.primitives.Doubles;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexSorting;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.Reference2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ReferenceArraySet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.CrashReport;
import net.minecraft.Util;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.SectionBufferBuilderPack;
import net.minecraft.client.renderer.SectionBufferBuilderPool;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.thread.ProcessorMailbox;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SectionRenderDispatcher {
    private static final int MAX_HIGH_PRIORITY_QUOTA = 2;
    private final PriorityBlockingQueue<SectionRenderDispatcher.RenderSection.CompileTask> toBatchHighPriority = Queues.newPriorityBlockingQueue();
    private final Queue<SectionRenderDispatcher.RenderSection.CompileTask> toBatchLowPriority = Queues.newLinkedBlockingDeque();
    private int highPriorityQuota = 2;
    private final Queue<Runnable> toUpload = Queues.newConcurrentLinkedQueue();
    final SectionBufferBuilderPack fixedBuffers;
    private final SectionBufferBuilderPool bufferPool;
    private volatile int toBatchCount;
    private volatile boolean closed;
    private final ProcessorMailbox<Runnable> mailbox;
    private final Executor executor;
    ClientLevel level;
    final LevelRenderer renderer;
    private Vec3 camera = Vec3.ZERO;

    public SectionRenderDispatcher(ClientLevel p_295274_, LevelRenderer p_295323_, Executor p_295234_, RenderBuffers p_307511_) {
        this.level = p_295274_;
        this.renderer = p_295323_;
        this.fixedBuffers = p_307511_.fixedBufferPack();
        this.bufferPool = p_307511_.sectionBufferPool();
        this.executor = p_295234_;
        this.mailbox = ProcessorMailbox.create(p_295234_, "Section Renderer");
        this.mailbox.tell(this::runTask);
    }

    public void setLevel(ClientLevel p_295112_) {
        this.level = p_295112_;
    }

    private void runTask() {
        if (!this.closed && !this.bufferPool.isEmpty()) {
            SectionRenderDispatcher.RenderSection.CompileTask sectionrenderdispatcher$rendersection$compiletask = this.pollTask();
            if (sectionrenderdispatcher$rendersection$compiletask != null) {
                SectionBufferBuilderPack sectionbufferbuilderpack = Objects.requireNonNull(this.bufferPool.acquire());
                this.toBatchCount = this.toBatchHighPriority.size() + this.toBatchLowPriority.size();
                CompletableFuture.supplyAsync(
                        Util.wrapThreadWithTaskName(
                            sectionrenderdispatcher$rendersection$compiletask.name(),
                            () -> sectionrenderdispatcher$rendersection$compiletask.doTask(sectionbufferbuilderpack)
                        ),
                        this.executor
                    )
                    .thenCompose(p_296185_ -> (CompletionStage<SectionRenderDispatcher.SectionTaskResult>)p_296185_)
                    .whenComplete((p_296170_, p_294818_) -> {
                        if (p_294818_ != null) {
                            Minecraft.getInstance().delayCrash(CrashReport.forThrowable(p_294818_, "Batching sections"));
                        } else {
                            this.mailbox.tell(() -> {
                                if (p_296170_ == SectionRenderDispatcher.SectionTaskResult.SUCCESSFUL) {
                                    sectionbufferbuilderpack.clearAll();
                                } else {
                                    sectionbufferbuilderpack.discardAll();
                                }

                                this.bufferPool.release(sectionbufferbuilderpack);
                                this.runTask();
                            });
                        }
                    });
            }
        }
    }

    @Nullable
    private SectionRenderDispatcher.RenderSection.CompileTask pollTask() {
        if (this.highPriorityQuota <= 0) {
            SectionRenderDispatcher.RenderSection.CompileTask sectionrenderdispatcher$rendersection$compiletask = this.toBatchLowPriority.poll();
            if (sectionrenderdispatcher$rendersection$compiletask != null) {
                this.highPriorityQuota = 2;
                return sectionrenderdispatcher$rendersection$compiletask;
            }
        }

        SectionRenderDispatcher.RenderSection.CompileTask sectionrenderdispatcher$rendersection$compiletask1 = this.toBatchHighPriority.poll();
        if (sectionrenderdispatcher$rendersection$compiletask1 != null) {
            this.highPriorityQuota--;
            return sectionrenderdispatcher$rendersection$compiletask1;
        } else {
            this.highPriorityQuota = 2;
            return this.toBatchLowPriority.poll();
        }
    }

    public String getStats() {
        return String.format(Locale.ROOT, "pC: %03d, pU: %02d, aB: %02d", this.toBatchCount, this.toUpload.size(), this.bufferPool.getFreeBufferCount());
    }

    public int getToBatchCount() {
        return this.toBatchCount;
    }

    public int getToUpload() {
        return this.toUpload.size();
    }

    public int getFreeBufferCount() {
        return this.bufferPool.getFreeBufferCount();
    }

    public void setCamera(Vec3 p_296331_) {
        this.camera = p_296331_;
    }

    public Vec3 getCameraPosition() {
        return this.camera;
    }

    public void uploadAllPendingUploads() {
        Runnable runnable;
        while ((runnable = this.toUpload.poll()) != null) {
            runnable.run();
        }
    }

    public void rebuildSectionSync(SectionRenderDispatcher.RenderSection p_296309_, RenderRegionCache p_294139_) {
        p_296309_.compileSync(p_294139_);
    }

    public void blockUntilClear() {
        this.clearBatchQueue();
    }

    public void schedule(SectionRenderDispatcher.RenderSection.CompileTask p_295825_) {
        if (!this.closed) {
            this.mailbox.tell(() -> {
                if (!this.closed) {
                    if (p_295825_.isHighPriority) {
                        this.toBatchHighPriority.offer(p_295825_);
                    } else {
                        this.toBatchLowPriority.offer(p_295825_);
                    }

                    this.toBatchCount = this.toBatchHighPriority.size() + this.toBatchLowPriority.size();
                    this.runTask();
                }
            });
        }
    }

    public CompletableFuture<Void> uploadSectionLayer(BufferBuilder.RenderedBuffer p_295447_, VertexBuffer p_294163_) {
        return this.closed ? CompletableFuture.completedFuture(null) : CompletableFuture.runAsync(() -> {
            if (p_294163_.isInvalid()) {
                p_295447_.release();
            } else {
                p_294163_.bind();
                p_294163_.upload(p_295447_);
                VertexBuffer.unbind();
            }
        }, this.toUpload::add);
    }

    private void clearBatchQueue() {
        while (!this.toBatchHighPriority.isEmpty()) {
            SectionRenderDispatcher.RenderSection.CompileTask sectionrenderdispatcher$rendersection$compiletask = this.toBatchHighPriority.poll();
            if (sectionrenderdispatcher$rendersection$compiletask != null) {
                sectionrenderdispatcher$rendersection$compiletask.cancel();
            }
        }

        while (!this.toBatchLowPriority.isEmpty()) {
            SectionRenderDispatcher.RenderSection.CompileTask sectionrenderdispatcher$rendersection$compiletask1 = this.toBatchLowPriority.poll();
            if (sectionrenderdispatcher$rendersection$compiletask1 != null) {
                sectionrenderdispatcher$rendersection$compiletask1.cancel();
            }
        }

        this.toBatchCount = 0;
    }

    public boolean isQueueEmpty() {
        return this.toBatchCount == 0 && this.toUpload.isEmpty();
    }

    public void dispose() {
        this.closed = true;
        this.clearBatchQueue();
        this.uploadAllPendingUploads();
    }

    @OnlyIn(Dist.CLIENT)
    public static class CompiledSection {
        public static final SectionRenderDispatcher.CompiledSection UNCOMPILED = new SectionRenderDispatcher.CompiledSection() {
            @Override
            public boolean facesCanSeeEachother(Direction p_296238_, Direction p_294727_) {
                return false;
            }
        };
        final Set<RenderType> hasBlocks = new ObjectArraySet<>(RenderType.chunkBufferLayers().size());
        final List<BlockEntity> renderableBlockEntities = Lists.newArrayList();
        VisibilitySet visibilitySet = new VisibilitySet();
        @Nullable
        BufferBuilder.SortState transparencyState;

        public boolean hasNoRenderableLayers() {
            return this.hasBlocks.isEmpty();
        }

        public boolean isEmpty(RenderType p_296192_) {
            return !this.hasBlocks.contains(p_296192_);
        }

        public List<BlockEntity> getRenderableBlockEntities() {
            return this.renderableBlockEntities;
        }

        public boolean facesCanSeeEachother(Direction p_295753_, Direction p_294424_) {
            return this.visibilitySet.visibilityBetween(p_295753_, p_294424_);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public class RenderSection {
        public static final int SIZE = 16;
        public final int index;
        public final AtomicReference<SectionRenderDispatcher.CompiledSection> compiled = new AtomicReference<>(
            SectionRenderDispatcher.CompiledSection.UNCOMPILED
        );
        final AtomicInteger initialCompilationCancelCount = new AtomicInteger(0);
        @Nullable
        private SectionRenderDispatcher.RenderSection.RebuildTask lastRebuildTask;
        @Nullable
        private SectionRenderDispatcher.RenderSection.ResortTransparencyTask lastResortTransparencyTask;
        private final Set<BlockEntity> globalBlockEntities = Sets.newHashSet();
        private final Map<RenderType, VertexBuffer> buffers = RenderType.chunkBufferLayers()
            .stream()
            .collect(Collectors.toMap(p_295245_ -> (RenderType)p_295245_, p_295640_ -> new VertexBuffer(VertexBuffer.Usage.STATIC)));
        private AABB bb;
        private boolean dirty = true;
        final BlockPos.MutableBlockPos origin = new BlockPos.MutableBlockPos(-1, -1, -1);
        private final BlockPos.MutableBlockPos[] relativeOrigins = Util.make(new BlockPos.MutableBlockPos[6], p_294717_ -> {
            for (int i = 0; i < p_294717_.length; i++) {
                p_294717_[i] = new BlockPos.MutableBlockPos();
            }
        });
        private boolean playerChanged;

        public RenderSection(int p_295197_, int p_295159_, int p_294506_, int p_294392_) {
            this.index = p_295197_;
            this.setOrigin(p_295159_, p_294506_, p_294392_);
        }

        private boolean doesChunkExistAt(BlockPos p_295253_) {
            return SectionRenderDispatcher.this.level
                    .getChunk(SectionPos.blockToSectionCoord(p_295253_.getX()), SectionPos.blockToSectionCoord(p_295253_.getZ()), ChunkStatus.FULL, false)
                != null;
        }

        public boolean hasAllNeighbors() {
            int i = 24;
            return !(this.getDistToPlayerSqr() > 576.0)
                ? true
                : this.doesChunkExistAt(this.relativeOrigins[Direction.WEST.ordinal()])
                    && this.doesChunkExistAt(this.relativeOrigins[Direction.NORTH.ordinal()])
                    && this.doesChunkExistAt(this.relativeOrigins[Direction.EAST.ordinal()])
                    && this.doesChunkExistAt(this.relativeOrigins[Direction.SOUTH.ordinal()]);
        }

        public AABB getBoundingBox() {
            return this.bb;
        }

        public VertexBuffer getBuffer(RenderType p_294497_) {
            return this.buffers.get(p_294497_);
        }

        public void setOrigin(int p_294148_, int p_295137_, int p_295706_) {
            this.reset();
            this.origin.set(p_294148_, p_295137_, p_295706_);
            this.bb = new AABB(
                (double)p_294148_, (double)p_295137_, (double)p_295706_, (double)(p_294148_ + 16), (double)(p_295137_ + 16), (double)(p_295706_ + 16)
            );

            for (Direction direction : Direction.values()) {
                this.relativeOrigins[direction.ordinal()].set(this.origin).move(direction, 16);
            }
        }

        protected double getDistToPlayerSqr() {
            Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
            double d0 = this.bb.minX + 8.0 - camera.getPosition().x;
            double d1 = this.bb.minY + 8.0 - camera.getPosition().y;
            double d2 = this.bb.minZ + 8.0 - camera.getPosition().z;
            return d0 * d0 + d1 * d1 + d2 * d2;
        }

        void beginLayer(BufferBuilder p_294230_) {
            p_294230_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.BLOCK);
        }

        public SectionRenderDispatcher.CompiledSection getCompiled() {
            return this.compiled.get();
        }

        private void reset() {
            this.cancelTasks();
            this.compiled.set(SectionRenderDispatcher.CompiledSection.UNCOMPILED);
            this.dirty = true;
        }

        public void releaseBuffers() {
            this.reset();
            this.buffers.values().forEach(VertexBuffer::close);
        }

        public BlockPos getOrigin() {
            return this.origin;
        }

        public void setDirty(boolean p_295417_) {
            boolean flag = this.dirty;
            this.dirty = true;
            this.playerChanged = p_295417_ | (flag && this.playerChanged);
        }

        public void setNotDirty() {
            this.dirty = false;
            this.playerChanged = false;
        }

        public boolean isDirty() {
            return this.dirty;
        }

        public boolean isDirtyFromPlayer() {
            return this.dirty && this.playerChanged;
        }

        public BlockPos getRelativeOrigin(Direction p_296100_) {
            return this.relativeOrigins[p_296100_.ordinal()];
        }

        public boolean resortTransparency(RenderType p_295679_, SectionRenderDispatcher p_294363_) {
            SectionRenderDispatcher.CompiledSection sectionrenderdispatcher$compiledsection = this.getCompiled();
            if (this.lastResortTransparencyTask != null) {
                this.lastResortTransparencyTask.cancel();
            }

            if (!sectionrenderdispatcher$compiledsection.hasBlocks.contains(p_295679_)) {
                return false;
            } else {
                this.lastResortTransparencyTask = new SectionRenderDispatcher.RenderSection.ResortTransparencyTask(
                    this.getDistToPlayerSqr(), sectionrenderdispatcher$compiledsection
                );
                p_294363_.schedule(this.lastResortTransparencyTask);
                return true;
            }
        }

        protected boolean cancelTasks() {
            boolean flag = false;
            if (this.lastRebuildTask != null) {
                this.lastRebuildTask.cancel();
                this.lastRebuildTask = null;
                flag = true;
            }

            if (this.lastResortTransparencyTask != null) {
                this.lastResortTransparencyTask.cancel();
                this.lastResortTransparencyTask = null;
            }

            return flag;
        }

        public SectionRenderDispatcher.RenderSection.CompileTask createCompileTask(RenderRegionCache p_295324_) {
            boolean flag = this.cancelTasks();
            BlockPos blockpos = this.origin.immutable();
            int i = 1;
            var additionalRenderers = net.neoforged.neoforge.client.ClientHooks.gatherAdditionalRenderers(blockpos, SectionRenderDispatcher.this.level);
            RenderChunkRegion renderchunkregion = p_295324_.createRegion(
                SectionRenderDispatcher.this.level, blockpos.offset(-1, -1, -1), blockpos.offset(16, 16, 16), 1, additionalRenderers.isEmpty()
            );
            boolean flag1 = this.compiled.get() == SectionRenderDispatcher.CompiledSection.UNCOMPILED;
            if (flag1 && flag) {
                this.initialCompilationCancelCount.incrementAndGet();
            }

            this.lastRebuildTask = new SectionRenderDispatcher.RenderSection.RebuildTask(
                this.getDistToPlayerSqr(), renderchunkregion, !flag1 || this.initialCompilationCancelCount.get() > 2, additionalRenderers
            );
            return this.lastRebuildTask;
        }

        public void rebuildSectionAsync(SectionRenderDispatcher p_295901_, RenderRegionCache p_294660_) {
            SectionRenderDispatcher.RenderSection.CompileTask sectionrenderdispatcher$rendersection$compiletask = this.createCompileTask(p_294660_);
            p_295901_.schedule(sectionrenderdispatcher$rendersection$compiletask);
        }

        void updateGlobalBlockEntities(Collection<BlockEntity> p_296155_) {
            Set<BlockEntity> set = Sets.newHashSet(p_296155_);
            Set<BlockEntity> set1;
            synchronized (this.globalBlockEntities) {
                set1 = Sets.newHashSet(this.globalBlockEntities);
                set.removeAll(this.globalBlockEntities);
                set1.removeAll(p_296155_);
                this.globalBlockEntities.clear();
                this.globalBlockEntities.addAll(p_296155_);
            }

            SectionRenderDispatcher.this.renderer.updateGlobalBlockEntities(set1, set);
        }

        public void compileSync(RenderRegionCache p_296018_) {
            SectionRenderDispatcher.RenderSection.CompileTask sectionrenderdispatcher$rendersection$compiletask = this.createCompileTask(p_296018_);
            sectionrenderdispatcher$rendersection$compiletask.doTask(SectionRenderDispatcher.this.fixedBuffers);
        }

        public boolean isAxisAlignedWith(int p_295743_, int p_295344_, int p_295518_) {
            BlockPos blockpos = this.getOrigin();
            return p_295743_ == SectionPos.blockToSectionCoord(blockpos.getX())
                || p_295518_ == SectionPos.blockToSectionCoord(blockpos.getZ())
                || p_295344_ == SectionPos.blockToSectionCoord(blockpos.getY());
        }

        @OnlyIn(Dist.CLIENT)
        abstract class CompileTask implements Comparable<SectionRenderDispatcher.RenderSection.CompileTask> {
            protected final double distAtCreation;
            protected final AtomicBoolean isCancelled = new AtomicBoolean(false);
            protected final boolean isHighPriority;

            public CompileTask(double p_294428_, boolean p_295051_) {
                this.distAtCreation = p_294428_;
                this.isHighPriority = p_295051_;
            }

            public abstract CompletableFuture<SectionRenderDispatcher.SectionTaskResult> doTask(SectionBufferBuilderPack p_294622_);

            public abstract void cancel();

            protected abstract String name();

            public int compareTo(SectionRenderDispatcher.RenderSection.CompileTask p_296186_) {
                return Doubles.compare(this.distAtCreation, p_296186_.distAtCreation);
            }
        }

        @OnlyIn(Dist.CLIENT)
        class RebuildTask extends SectionRenderDispatcher.RenderSection.CompileTask {
            @Nullable
            protected RenderChunkRegion region;
            private final List<net.neoforged.neoforge.client.event.AddSectionGeometryEvent.AdditionalSectionRenderer> additionalRenderers;

            @Deprecated
            public RebuildTask(double p_294400_, @Nullable RenderChunkRegion p_294382_, boolean p_295207_) {
                this(p_294400_, p_294382_, p_295207_, List.of());
            }

            public RebuildTask(double p_294400_, @Nullable RenderChunkRegion p_294382_, boolean p_295207_, List<net.neoforged.neoforge.client.event.AddSectionGeometryEvent.AdditionalSectionRenderer> additionalRenderers) {
                super(p_294400_, p_295207_);
                this.region = p_294382_;
                this.additionalRenderers = additionalRenderers;
            }

            @Override
            protected String name() {
                return "rend_chk_rebuild";
            }

            @Override
            public CompletableFuture<SectionRenderDispatcher.SectionTaskResult> doTask(SectionBufferBuilderPack p_296138_) {
                if (this.isCancelled.get()) {
                    return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                } else if (!RenderSection.this.hasAllNeighbors()) {
                    this.region = null;
                    RenderSection.this.setDirty(false);
                    this.isCancelled.set(true);
                    return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                } else if (this.isCancelled.get()) {
                    return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                } else {
                    Vec3 vec3 = SectionRenderDispatcher.this.getCameraPosition();
                    float f = (float)vec3.x;
                    float f1 = (float)vec3.y;
                    float f2 = (float)vec3.z;
                    SectionRenderDispatcher.RenderSection.RebuildTask.CompileResults sectionrenderdispatcher$rendersection$rebuildtask$compileresults = this.compile(
                        f, f1, f2, p_296138_
                    );
                    RenderSection.this.updateGlobalBlockEntities(sectionrenderdispatcher$rendersection$rebuildtask$compileresults.globalBlockEntities);
                    if (this.isCancelled.get()) {
                        sectionrenderdispatcher$rendersection$rebuildtask$compileresults.renderedLayers.values().forEach(BufferBuilder.RenderedBuffer::release);
                        return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                    } else {
                        SectionRenderDispatcher.CompiledSection sectionrenderdispatcher$compiledsection = new SectionRenderDispatcher.CompiledSection();
                        sectionrenderdispatcher$compiledsection.visibilitySet = sectionrenderdispatcher$rendersection$rebuildtask$compileresults.visibilitySet;
                        sectionrenderdispatcher$compiledsection.renderableBlockEntities
                            .addAll(sectionrenderdispatcher$rendersection$rebuildtask$compileresults.blockEntities);
                        sectionrenderdispatcher$compiledsection.transparencyState = sectionrenderdispatcher$rendersection$rebuildtask$compileresults.transparencyState;
                        List<CompletableFuture<Void>> list = Lists.newArrayList();
                        sectionrenderdispatcher$rendersection$rebuildtask$compileresults.renderedLayers.forEach((p_295005_, p_295071_) -> {
                            list.add(SectionRenderDispatcher.this.uploadSectionLayer(p_295071_, RenderSection.this.getBuffer(p_295005_)));
                            sectionrenderdispatcher$compiledsection.hasBlocks.add(p_295005_);
                        });
                        return Util.sequenceFailFast(list).handle((p_295515_, p_295905_) -> {
                            if (p_295905_ != null && !(p_295905_ instanceof CancellationException) && !(p_295905_ instanceof InterruptedException)) {
                                Minecraft.getInstance().delayCrash(CrashReport.forThrowable(p_295905_, "Rendering section"));
                            }

                            if (this.isCancelled.get()) {
                                return SectionRenderDispatcher.SectionTaskResult.CANCELLED;
                            } else {
                                RenderSection.this.compiled.set(sectionrenderdispatcher$compiledsection);
                                RenderSection.this.initialCompilationCancelCount.set(0);
                                SectionRenderDispatcher.this.renderer.addRecentlyCompiledSection(RenderSection.this);
                                return SectionRenderDispatcher.SectionTaskResult.SUCCESSFUL;
                            }
                        });
                    }
                }
            }

            private SectionRenderDispatcher.RenderSection.RebuildTask.CompileResults compile(
                float p_294894_, float p_295437_, float p_294465_, SectionBufferBuilderPack p_294319_
            ) {
                SectionRenderDispatcher.RenderSection.RebuildTask.CompileResults sectionrenderdispatcher$rendersection$rebuildtask$compileresults = new SectionRenderDispatcher.RenderSection.RebuildTask.CompileResults();
                int i = 1;
                BlockPos blockpos = RenderSection.this.origin.immutable();
                BlockPos blockpos1 = blockpos.offset(15, 15, 15);
                VisGraph visgraph = new VisGraph();
                RenderChunkRegion renderchunkregion = this.region;
                this.region = null;
                PoseStack posestack = new PoseStack();
                if (renderchunkregion != null) {
                    ModelBlockRenderer.enableCaching();
                    Set<RenderType> set = new ReferenceArraySet<>(RenderType.chunkBufferLayers().size());
                    RandomSource randomsource = RandomSource.create();
                    BlockRenderDispatcher blockrenderdispatcher = Minecraft.getInstance().getBlockRenderer();

                    for (BlockPos blockpos2 : BlockPos.betweenClosed(blockpos, blockpos1)) {
                        BlockState blockstate = renderchunkregion.getBlockState(blockpos2);
                        if (blockstate.isSolidRender(renderchunkregion, blockpos2)) {
                            visgraph.setOpaque(blockpos2);
                        }

                        if (blockstate.hasBlockEntity()) {
                            BlockEntity blockentity = renderchunkregion.getBlockEntity(blockpos2);
                            if (blockentity != null) {
                                this.handleBlockEntity(sectionrenderdispatcher$rendersection$rebuildtask$compileresults, blockentity);
                            }
                        }

                        FluidState fluidstate = blockstate.getFluidState();
                        if (!fluidstate.isEmpty()) {
                            RenderType rendertype = ItemBlockRenderTypes.getRenderLayer(fluidstate);
                            BufferBuilder bufferbuilder = p_294319_.builder(rendertype);
                            if (set.add(rendertype)) {
                                RenderSection.this.beginLayer(bufferbuilder);
                            }

                            blockrenderdispatcher.renderLiquid(blockpos2, renderchunkregion, bufferbuilder, blockstate, fluidstate);
                        }

                        if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
                            var model = blockrenderdispatcher.getBlockModel(blockstate);
                            var modelData = renderchunkregion.getModelData(blockpos2);
                            modelData = model.getModelData(renderchunkregion, blockpos2, blockstate, modelData);
                            randomsource.setSeed(blockstate.getSeed(blockpos2));
                            for (RenderType rendertype2 : model.getRenderTypes(blockstate, randomsource, modelData)) {
                            BufferBuilder bufferbuilder2 = p_294319_.builder(rendertype2);
                            if (set.add(rendertype2)) {
                                RenderSection.this.beginLayer(bufferbuilder2);
                            }

                            posestack.pushPose();
                            posestack.translate((float)(blockpos2.getX() & 15), (float)(blockpos2.getY() & 15), (float)(blockpos2.getZ() & 15));
                            blockrenderdispatcher.renderBatched(blockstate, blockpos2, renderchunkregion, posestack, bufferbuilder2, true, randomsource, modelData, rendertype2);
                            posestack.popPose();
                            }
                        }
                    }
                    net.neoforged.neoforge.client.ClientHooks.addAdditionalGeometry(
                        additionalRenderers, type -> {
                            BufferBuilder builder = p_294319_.builder(type);
                            if (set.add(type)) {
                                RenderSection.this.beginLayer(builder);
                            }
                            return builder;
                        }, renderchunkregion, posestack
                    );

                    if (set.contains(RenderType.translucent())) {
                        BufferBuilder bufferbuilder1 = p_294319_.builder(RenderType.translucent());
                        if (!bufferbuilder1.isCurrentBatchEmpty()) {
                            bufferbuilder1.setQuadSorting(
                                VertexSorting.byDistance(
                                    p_294894_ - (float)blockpos.getX(), p_295437_ - (float)blockpos.getY(), p_294465_ - (float)blockpos.getZ()
                                )
                            );
                            sectionrenderdispatcher$rendersection$rebuildtask$compileresults.transparencyState = bufferbuilder1.getSortState();
                        }
                    }

                    for (RenderType rendertype1 : set) {
                        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = p_294319_.builder(rendertype1).endOrDiscardIfEmpty();
                        if (bufferbuilder$renderedbuffer != null) {
                            sectionrenderdispatcher$rendersection$rebuildtask$compileresults.renderedLayers.put(rendertype1, bufferbuilder$renderedbuffer);
                        }
                    }

                    ModelBlockRenderer.clearCache();
                }

                sectionrenderdispatcher$rendersection$rebuildtask$compileresults.visibilitySet = visgraph.resolve();
                return sectionrenderdispatcher$rendersection$rebuildtask$compileresults;
            }

            private <E extends BlockEntity> void handleBlockEntity(SectionRenderDispatcher.RenderSection.RebuildTask.CompileResults p_294198_, E p_296214_) {
                BlockEntityRenderer<E> blockentityrenderer = Minecraft.getInstance().getBlockEntityRenderDispatcher().getRenderer(p_296214_);
                if (blockentityrenderer != null) {
                    if (blockentityrenderer.shouldRenderOffScreen(p_296214_)) {
                        p_294198_.globalBlockEntities.add(p_296214_);
                    } else {
                        p_294198_.blockEntities.add(p_296214_);
                    }
                }
            }

            @Override
            public void cancel() {
                this.region = null;
                if (this.isCancelled.compareAndSet(false, true)) {
                    RenderSection.this.setDirty(false);
                }
            }

            @OnlyIn(Dist.CLIENT)
            static final class CompileResults {
                public final List<BlockEntity> globalBlockEntities = new ArrayList<>();
                public final List<BlockEntity> blockEntities = new ArrayList<>();
                public final Map<RenderType, BufferBuilder.RenderedBuffer> renderedLayers = new Reference2ObjectArrayMap<>();
                public VisibilitySet visibilitySet = new VisibilitySet();
                @Nullable
                public BufferBuilder.SortState transparencyState;
            }
        }

        @OnlyIn(Dist.CLIENT)
        class ResortTransparencyTask extends SectionRenderDispatcher.RenderSection.CompileTask {
            private final SectionRenderDispatcher.CompiledSection compiledSection;

            public ResortTransparencyTask(double p_294102_, SectionRenderDispatcher.CompiledSection p_294601_) {
                super(p_294102_, true);
                this.compiledSection = p_294601_;
            }

            @Override
            protected String name() {
                return "rend_chk_sort";
            }

            @Override
            public CompletableFuture<SectionRenderDispatcher.SectionTaskResult> doTask(SectionBufferBuilderPack p_295160_) {
                if (this.isCancelled.get()) {
                    return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                } else if (!RenderSection.this.hasAllNeighbors()) {
                    this.isCancelled.set(true);
                    return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                } else if (this.isCancelled.get()) {
                    return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                } else {
                    Vec3 vec3 = SectionRenderDispatcher.this.getCameraPosition();
                    float f = (float)vec3.x;
                    float f1 = (float)vec3.y;
                    float f2 = (float)vec3.z;
                    BufferBuilder.SortState bufferbuilder$sortstate = this.compiledSection.transparencyState;
                    if (bufferbuilder$sortstate != null && !this.compiledSection.isEmpty(RenderType.translucent())) {
                        BufferBuilder bufferbuilder = p_295160_.builder(RenderType.translucent());
                        RenderSection.this.beginLayer(bufferbuilder);
                        bufferbuilder.restoreSortState(bufferbuilder$sortstate);
                        bufferbuilder.setQuadSorting(
                            VertexSorting.byDistance(
                                f - (float)RenderSection.this.origin.getX(),
                                f1 - (float)RenderSection.this.origin.getY(),
                                f2 - (float)RenderSection.this.origin.getZ()
                            )
                        );
                        this.compiledSection.transparencyState = bufferbuilder.getSortState();
                        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = bufferbuilder.end();
                        if (this.isCancelled.get()) {
                            bufferbuilder$renderedbuffer.release();
                            return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                        } else {
                            CompletableFuture<SectionRenderDispatcher.SectionTaskResult> completablefuture = SectionRenderDispatcher.this.uploadSectionLayer(
                                    bufferbuilder$renderedbuffer, RenderSection.this.getBuffer(RenderType.translucent())
                                )
                                .thenApply(p_294714_ -> SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                            return completablefuture.handle(
                                (p_295896_, p_295826_) -> {
                                    if (p_295826_ != null && !(p_295826_ instanceof CancellationException) && !(p_295826_ instanceof InterruptedException)) {
                                        Minecraft.getInstance().delayCrash(CrashReport.forThrowable(p_295826_, "Rendering section"));
                                    }

                                    return this.isCancelled.get()
                                        ? SectionRenderDispatcher.SectionTaskResult.CANCELLED
                                        : SectionRenderDispatcher.SectionTaskResult.SUCCESSFUL;
                                }
                            );
                        }
                    } else {
                        return CompletableFuture.completedFuture(SectionRenderDispatcher.SectionTaskResult.CANCELLED);
                    }
                }
            }

            @Override
            public void cancel() {
                this.isCancelled.set(true);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    static enum SectionTaskResult {
        SUCCESSFUL,
        CANCELLED;
    }
}
