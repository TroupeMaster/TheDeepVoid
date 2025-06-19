package net.minecraft.client.renderer.chunk;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderChunkRegion implements BlockAndTintGetter {
    private final int centerX;
    private final int centerZ;
    protected final RenderChunk[][] chunks;
    protected final Level level;
    private final it.unimi.dsi.fastutil.longs.Long2ObjectFunction<net.neoforged.neoforge.client.model.data.ModelData> modelDataSnapshot;

    @Deprecated
    RenderChunkRegion(Level p_200456_, int p_200457_, int p_200458_, RenderChunk[][] p_200459_) {
        this(p_200456_, p_200457_, p_200458_, p_200459_, net.neoforged.neoforge.client.model.data.ModelDataManager.EMPTY_SNAPSHOT);
    }
    RenderChunkRegion(Level p_200456_, int p_200457_, int p_200458_, RenderChunk[][] p_200459_, it.unimi.dsi.fastutil.longs.Long2ObjectFunction<net.neoforged.neoforge.client.model.data.ModelData> modelDataSnapshot) {
        this.level = p_200456_;
        this.centerX = p_200457_;
        this.centerZ = p_200458_;
        this.chunks = p_200459_;
        this.modelDataSnapshot = modelDataSnapshot;
    }

    @Override
    public BlockState getBlockState(BlockPos p_112947_) {
        int i = SectionPos.blockToSectionCoord(p_112947_.getX()) - this.centerX;
        int j = SectionPos.blockToSectionCoord(p_112947_.getZ()) - this.centerZ;
        return this.chunks[i][j].getBlockState(p_112947_);
    }

    @Override
    public FluidState getFluidState(BlockPos p_112943_) {
        int i = SectionPos.blockToSectionCoord(p_112943_.getX()) - this.centerX;
        int j = SectionPos.blockToSectionCoord(p_112943_.getZ()) - this.centerZ;
        return this.chunks[i][j].getBlockState(p_112943_).getFluidState();
    }

    @Override
    public float getShade(Direction p_112940_, boolean p_112941_) {
        return this.level.getShade(p_112940_, p_112941_);
    }

    @Override
    public LevelLightEngine getLightEngine() {
        return this.level.getLightEngine();
    }

    @Nullable
    @Override
    public BlockEntity getBlockEntity(BlockPos p_112945_) {
        int i = SectionPos.blockToSectionCoord(p_112945_.getX()) - this.centerX;
        int j = SectionPos.blockToSectionCoord(p_112945_.getZ()) - this.centerZ;
        return this.chunks[i][j].getBlockEntity(p_112945_);
    }

    @Override
    public int getBlockTint(BlockPos p_112937_, ColorResolver p_112938_) {
        return this.level.getBlockTint(p_112937_, p_112938_);
    }

    @Override
    public int getMinBuildHeight() {
        return this.level.getMinBuildHeight();
    }

    @Override
    public int getHeight() {
        return this.level.getHeight();
    }

    @Override
    public float getShade(float normalX, float normalY, float normalZ, boolean shade) {
        return this.level.getShade(normalX, normalY, normalZ, shade);
    }

    @Override
    public net.neoforged.neoforge.client.model.data.ModelData getModelData(BlockPos pos) {
        return modelDataSnapshot.get(pos.asLong());
    }

    @Override
    public net.neoforged.neoforge.common.world.AuxiliaryLightManager getAuxLightManager(net.minecraft.world.level.ChunkPos pos) {
        int relX = pos.x - this.centerX;
        int relZ = pos.z - this.centerZ;
        return this.chunks[relX][relZ].wrapped.getAuxLightManager(pos);
    }
}
