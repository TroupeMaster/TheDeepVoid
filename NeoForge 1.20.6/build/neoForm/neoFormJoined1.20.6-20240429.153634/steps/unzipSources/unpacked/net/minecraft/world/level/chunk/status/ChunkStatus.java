package net.minecraft.world.level.chunk.status;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.jfr.JvmProfiler;
import net.minecraft.util.profiling.jfr.callback.ProfiledDuration;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.levelgen.Heightmap;

public class ChunkStatus {
    public static final int MAX_STRUCTURE_DISTANCE = 8;
    private static final EnumSet<Heightmap.Types> PRE_FEATURES = EnumSet.of(Heightmap.Types.OCEAN_FLOOR_WG, Heightmap.Types.WORLD_SURFACE_WG);
    public static final EnumSet<Heightmap.Types> POST_FEATURES = EnumSet.of(
        Heightmap.Types.OCEAN_FLOOR, Heightmap.Types.WORLD_SURFACE, Heightmap.Types.MOTION_BLOCKING, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES
    );
    public static final ChunkStatus EMPTY = register(
        "empty", null, -1, false, PRE_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateEmpty, ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus STRUCTURE_STARTS = register(
        "structure_starts",
        EMPTY,
        0,
        false,
        PRE_FEATURES,
        ChunkType.PROTOCHUNK,
        ChunkStatusTasks::generateStructureStarts,
        ChunkStatusTasks::loadStructureStarts
    );
    public static final ChunkStatus STRUCTURE_REFERENCES = register(
        "structure_references",
        STRUCTURE_STARTS,
        8,
        false,
        PRE_FEATURES,
        ChunkType.PROTOCHUNK,
        ChunkStatusTasks::generateStructureReferences,
        ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus BIOMES = register(
        "biomes", STRUCTURE_REFERENCES, 8, false, PRE_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateBiomes, ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus NOISE = register(
        "noise", BIOMES, 8, false, PRE_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateNoise, ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus SURFACE = register(
        "surface", NOISE, 8, false, PRE_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateSurface, ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus CARVERS = register(
        "carvers", SURFACE, 8, false, POST_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateCarvers, ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus FEATURES = register(
        "features", CARVERS, 8, false, POST_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateFeatures, ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus INITIALIZE_LIGHT = register(
        "initialize_light",
        FEATURES,
        0,
        false,
        POST_FEATURES,
        ChunkType.PROTOCHUNK,
        ChunkStatusTasks::generateInitializeLight,
        ChunkStatusTasks::loadInitializeLight
    );
    public static final ChunkStatus LIGHT = register(
        "light", INITIALIZE_LIGHT, 1, true, POST_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateLight, ChunkStatusTasks::loadLight
    );
    public static final ChunkStatus SPAWN = register(
        "spawn", LIGHT, 1, false, POST_FEATURES, ChunkType.PROTOCHUNK, ChunkStatusTasks::generateSpawn, ChunkStatusTasks::loadPassThrough
    );
    public static final ChunkStatus FULL = register(
        "full", SPAWN, 0, false, POST_FEATURES, ChunkType.LEVELCHUNK, ChunkStatusTasks::generateFull, ChunkStatusTasks::loadFull
    );
    private static final List<ChunkStatus> STATUS_BY_RANGE = ImmutableList.of(
        FULL,
        INITIALIZE_LIGHT,
        CARVERS,
        BIOMES,
        STRUCTURE_STARTS,
        STRUCTURE_STARTS,
        STRUCTURE_STARTS,
        STRUCTURE_STARTS,
        STRUCTURE_STARTS,
        STRUCTURE_STARTS,
        STRUCTURE_STARTS,
        STRUCTURE_STARTS
    );
    private static final IntList RANGE_BY_STATUS = Util.make(new IntArrayList(getStatusList().size()), p_331236_ -> {
        int i = 0;

        for (int j = getStatusList().size() - 1; j >= 0; j--) {
            while (i + 1 < STATUS_BY_RANGE.size() && j <= STATUS_BY_RANGE.get(i + 1).getIndex()) {
                i++;
            }

            p_331236_.add(0, i);
        }
    });
    private final int index;
    private final ChunkStatus parent;
    private final ChunkStatus.GenerationTask generationTask;
    private final ChunkStatus.LoadingTask loadingTask;
    private final int range;
    private final boolean hasLoadDependencies;
    private final ChunkType chunkType;
    private final EnumSet<Heightmap.Types> heightmapsAfter;

    private static ChunkStatus register(
        String p_330494_,
        @Nullable ChunkStatus p_331829_,
        int p_331568_,
        boolean p_330950_,
        EnumSet<Heightmap.Types> p_330717_,
        ChunkType p_331982_,
        ChunkStatus.GenerationTask p_331350_,
        ChunkStatus.LoadingTask p_331071_
    ) {
        return Registry.register(
            BuiltInRegistries.CHUNK_STATUS, p_330494_, new ChunkStatus(p_331829_, p_331568_, p_330950_, p_330717_, p_331982_, p_331350_, p_331071_)
        );
    }

    public static List<ChunkStatus> getStatusList() {
        List<ChunkStatus> list = Lists.newArrayList();

        ChunkStatus chunkstatus;
        for (chunkstatus = FULL; chunkstatus.getParent() != chunkstatus; chunkstatus = chunkstatus.getParent()) {
            list.add(chunkstatus);
        }

        list.add(chunkstatus);
        Collections.reverse(list);
        return list;
    }

    public static ChunkStatus getStatusAroundFullChunk(int p_331738_) {
        if (p_331738_ >= STATUS_BY_RANGE.size()) {
            return EMPTY;
        } else {
            return p_331738_ < 0 ? FULL : STATUS_BY_RANGE.get(p_331738_);
        }
    }

    public static int maxDistance() {
        return STATUS_BY_RANGE.size();
    }

    public static int getDistance(ChunkStatus p_330308_) {
        return RANGE_BY_STATUS.getInt(p_330308_.getIndex());
    }

    ChunkStatus(
        @Nullable ChunkStatus p_330316_,
        int p_331005_,
        boolean p_331192_,
        EnumSet<Heightmap.Types> p_331442_,
        ChunkType p_331412_,
        ChunkStatus.GenerationTask p_331787_,
        ChunkStatus.LoadingTask p_330251_
    ) {
        this.parent = p_330316_ == null ? this : p_330316_;
        this.generationTask = p_331787_;
        this.loadingTask = p_330251_;
        this.range = p_331005_;
        this.hasLoadDependencies = p_331192_;
        this.chunkType = p_331412_;
        this.heightmapsAfter = p_331442_;
        this.index = p_330316_ == null ? 0 : p_330316_.getIndex() + 1;
    }

    public int getIndex() {
        return this.index;
    }

    public ChunkStatus getParent() {
        return this.parent;
    }

    public CompletableFuture<ChunkAccess> generate(WorldGenContext p_330418_, Executor p_331595_, ToFullChunk p_330877_, List<ChunkAccess> p_331519_) {
        ChunkAccess chunkaccess = p_331519_.get(p_331519_.size() / 2);
        ProfiledDuration profiledduration = JvmProfiler.INSTANCE.onChunkGenerate(chunkaccess.getPos(), p_330418_.level().dimension(), this.toString());
        return this.generationTask.doWork(p_330418_, this, p_331595_, p_330877_, p_331519_, chunkaccess).thenApply(p_331239_ -> {
            if (p_331239_ instanceof ProtoChunk protochunk && !protochunk.getStatus().isOrAfter(this)) {
                protochunk.setStatus(this);
            }

            if (profiledduration != null) {
                profiledduration.finish();
            }

            return (ChunkAccess)p_331239_;
        });
    }

    public CompletableFuture<ChunkAccess> load(WorldGenContext p_331669_, ToFullChunk p_332161_, ChunkAccess p_330578_) {
        return this.loadingTask.doWork(p_331669_, this, p_332161_, p_330578_);
    }

    public int getRange() {
        return this.range;
    }

    public boolean hasLoadDependencies() {
        return this.hasLoadDependencies;
    }

    public ChunkType getChunkType() {
        return this.chunkType;
    }

    public static ChunkStatus byName(String p_330923_) {
        return BuiltInRegistries.CHUNK_STATUS.get(ResourceLocation.tryParse(p_330923_));
    }

    public EnumSet<Heightmap.Types> heightmapsAfter() {
        return this.heightmapsAfter;
    }

    public boolean isOrAfter(ChunkStatus p_330216_) {
        return this.getIndex() >= p_330216_.getIndex();
    }

    @Override
    public String toString() {
        return BuiltInRegistries.CHUNK_STATUS.getKey(this).toString();
    }

    @FunctionalInterface
    protected interface GenerationTask {
        CompletableFuture<ChunkAccess> doWork(
            WorldGenContext p_331381_, ChunkStatus p_332130_, Executor p_332078_, ToFullChunk p_330356_, List<ChunkAccess> p_331598_, ChunkAccess p_330674_
        );
    }

    @FunctionalInterface
    protected interface LoadingTask {
        CompletableFuture<ChunkAccess> doWork(WorldGenContext p_330902_, ChunkStatus p_332197_, ToFullChunk p_331879_, ChunkAccess p_331288_);
    }
}
