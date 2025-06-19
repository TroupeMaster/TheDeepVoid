package net.minecraft.world.level.chunk.status;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ThreadedLevelLightEngine;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.levelgen.BelowZeroRetrogen;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blending.Blender;

public class ChunkStatusTasks {
    private static boolean isLighted(ChunkAccess p_330524_) {
        return p_330524_.getStatus().isOrAfter(ChunkStatus.LIGHT) && p_330524_.isLightCorrect();
    }

    static CompletableFuture<ChunkAccess> generateEmpty(
        WorldGenContext p_331541_, ChunkStatus p_330357_, Executor p_331615_, ToFullChunk p_331065_, List<ChunkAccess> p_331856_, ChunkAccess p_330295_
    ) {
        return CompletableFuture.completedFuture(p_330295_);
    }

    static CompletableFuture<ChunkAccess> loadPassThrough(WorldGenContext p_331013_, ChunkStatus p_331984_, ToFullChunk p_331211_, ChunkAccess p_332207_) {
        return CompletableFuture.completedFuture(p_332207_);
    }

    static CompletableFuture<ChunkAccess> generateStructureStarts(
        WorldGenContext p_331607_, ChunkStatus p_331241_, Executor p_331817_, ToFullChunk p_331081_, List<ChunkAccess> p_331840_, ChunkAccess p_330224_
    ) {
        ServerLevel serverlevel = p_331607_.level();
        if (serverlevel.getServer().getWorldData().worldGenOptions().generateStructures()) {
            p_331607_.generator()
                .createStructures(
                    serverlevel.registryAccess(),
                    serverlevel.getChunkSource().getGeneratorState(),
                    serverlevel.structureManager(),
                    p_330224_,
                    p_331607_.structureManager()
                );
        }

        serverlevel.onStructureStartsAvailable(p_330224_);
        return CompletableFuture.completedFuture(p_330224_);
    }

    static CompletableFuture<ChunkAccess> loadStructureStarts(WorldGenContext p_331337_, ChunkStatus p_331340_, ToFullChunk p_330545_, ChunkAccess p_331647_) {
        p_331337_.level().onStructureStartsAvailable(p_331647_);
        return CompletableFuture.completedFuture(p_331647_);
    }

    static CompletableFuture<ChunkAccess> generateStructureReferences(
        WorldGenContext p_331037_, ChunkStatus p_330278_, Executor p_331892_, ToFullChunk p_331036_, List<ChunkAccess> p_331402_, ChunkAccess p_331453_
    ) {
        ServerLevel serverlevel = p_331037_.level();
        WorldGenRegion worldgenregion = new WorldGenRegion(serverlevel, p_331402_, p_330278_, -1);
        p_331037_.generator().createReferences(worldgenregion, serverlevel.structureManager().forWorldGenRegion(worldgenregion), p_331453_);
        return CompletableFuture.completedFuture(p_331453_);
    }

    static CompletableFuture<ChunkAccess> generateBiomes(
        WorldGenContext p_331619_, ChunkStatus p_331495_, Executor p_331882_, ToFullChunk p_330522_, List<ChunkAccess> p_331341_, ChunkAccess p_332054_
    ) {
        ServerLevel serverlevel = p_331619_.level();
        WorldGenRegion worldgenregion = new WorldGenRegion(serverlevel, p_331341_, p_331495_, -1);
        return p_331619_.generator()
            .createBiomes(
                p_331882_,
                serverlevel.getChunkSource().randomState(),
                Blender.of(worldgenregion),
                serverlevel.structureManager().forWorldGenRegion(worldgenregion),
                p_332054_
            );
    }

    static CompletableFuture<ChunkAccess> generateNoise(
        WorldGenContext p_331452_, ChunkStatus p_330609_, Executor p_331428_, ToFullChunk p_331663_, List<ChunkAccess> p_331259_, ChunkAccess p_330927_
    ) {
        ServerLevel serverlevel = p_331452_.level();
        WorldGenRegion worldgenregion = new WorldGenRegion(serverlevel, p_331259_, p_330609_, 0);
        return p_331452_.generator()
            .fillFromNoise(
                p_331428_,
                Blender.of(worldgenregion),
                serverlevel.getChunkSource().randomState(),
                serverlevel.structureManager().forWorldGenRegion(worldgenregion),
                p_330927_
            )
            .thenApply(p_330442_ -> {
                if (p_330442_ instanceof ProtoChunk protochunk) {
                    BelowZeroRetrogen belowzeroretrogen = protochunk.getBelowZeroRetrogen();
                    if (belowzeroretrogen != null) {
                        BelowZeroRetrogen.replaceOldBedrock(protochunk);
                        if (belowzeroretrogen.hasBedrockHoles()) {
                            belowzeroretrogen.applyBedrockMask(protochunk);
                        }
                    }
                }

                return (ChunkAccess)p_330442_;
            });
    }

    static CompletableFuture<ChunkAccess> generateSurface(
        WorldGenContext p_331468_, ChunkStatus p_331484_, Executor p_331826_, ToFullChunk p_331299_, List<ChunkAccess> p_331459_, ChunkAccess p_331100_
    ) {
        ServerLevel serverlevel = p_331468_.level();
        WorldGenRegion worldgenregion = new WorldGenRegion(serverlevel, p_331459_, p_331484_, 0);
        p_331468_.generator()
            .buildSurface(
                worldgenregion, serverlevel.structureManager().forWorldGenRegion(worldgenregion), serverlevel.getChunkSource().randomState(), p_331100_
            );
        return CompletableFuture.completedFuture(p_331100_);
    }

    static CompletableFuture<ChunkAccess> generateCarvers(
        WorldGenContext p_331858_, ChunkStatus p_330487_, Executor p_332080_, ToFullChunk p_330329_, List<ChunkAccess> p_331279_, ChunkAccess p_330818_
    ) {
        ServerLevel serverlevel = p_331858_.level();
        WorldGenRegion worldgenregion = new WorldGenRegion(serverlevel, p_331279_, p_330487_, 0);
        if (p_330818_ instanceof ProtoChunk protochunk) {
            Blender.addAroundOldChunksCarvingMaskFilter(worldgenregion, protochunk);
        }

        p_331858_.generator()
            .applyCarvers(
                worldgenregion,
                serverlevel.getSeed(),
                serverlevel.getChunkSource().randomState(),
                serverlevel.getBiomeManager(),
                serverlevel.structureManager().forWorldGenRegion(worldgenregion),
                p_330818_,
                GenerationStep.Carving.AIR
            );
        return CompletableFuture.completedFuture(p_330818_);
    }

    static CompletableFuture<ChunkAccess> generateFeatures(
        WorldGenContext p_330280_, ChunkStatus p_332146_, Executor p_330293_, ToFullChunk p_331537_, List<ChunkAccess> p_331977_, ChunkAccess p_332040_
    ) {
        ServerLevel serverlevel = p_330280_.level();
        Heightmap.primeHeightmaps(
            p_332040_,
            EnumSet.of(Heightmap.Types.MOTION_BLOCKING, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Heightmap.Types.OCEAN_FLOOR, Heightmap.Types.WORLD_SURFACE)
        );
        WorldGenRegion worldgenregion = new WorldGenRegion(serverlevel, p_331977_, p_332146_, 1);
        p_330280_.generator().applyBiomeDecoration(worldgenregion, p_332040_, serverlevel.structureManager().forWorldGenRegion(worldgenregion));
        Blender.generateBorderTicks(worldgenregion, p_332040_);
        return CompletableFuture.completedFuture(p_332040_);
    }

    static CompletableFuture<ChunkAccess> generateInitializeLight(
        WorldGenContext p_330586_, ChunkStatus p_330837_, Executor p_332096_, ToFullChunk p_330908_, List<ChunkAccess> p_332029_, ChunkAccess p_331237_
    ) {
        return initializeLight(p_330586_.lightEngine(), p_331237_);
    }

    static CompletableFuture<ChunkAccess> loadInitializeLight(WorldGenContext p_331356_, ChunkStatus p_330870_, ToFullChunk p_330548_, ChunkAccess p_331930_) {
        return initializeLight(p_331356_.lightEngine(), p_331930_);
    }

    private static CompletableFuture<ChunkAccess> initializeLight(ThreadedLevelLightEngine p_331672_, ChunkAccess p_331196_) {
        p_331196_.initializeLightSources();
        ((ProtoChunk)p_331196_).setLightEngine(p_331672_);
        boolean flag = isLighted(p_331196_);
        return p_331672_.initializeLight(p_331196_, flag);
    }

    static CompletableFuture<ChunkAccess> generateLight(
        WorldGenContext p_330378_, ChunkStatus p_331800_, Executor p_331960_, ToFullChunk p_331543_, List<ChunkAccess> p_330598_, ChunkAccess p_332182_
    ) {
        return lightChunk(p_330378_.lightEngine(), p_332182_);
    }

    static CompletableFuture<ChunkAccess> loadLight(WorldGenContext p_330789_, ChunkStatus p_330518_, ToFullChunk p_332086_, ChunkAccess p_330459_) {
        return lightChunk(p_330789_.lightEngine(), p_330459_);
    }

    private static CompletableFuture<ChunkAccess> lightChunk(ThreadedLevelLightEngine p_331899_, ChunkAccess p_331315_) {
        boolean flag = isLighted(p_331315_);
        return p_331899_.lightChunk(p_331315_, flag);
    }

    static CompletableFuture<ChunkAccess> generateSpawn(
        WorldGenContext p_330441_, ChunkStatus p_332117_, Executor p_330650_, ToFullChunk p_330322_, List<ChunkAccess> p_331338_, ChunkAccess p_331907_
    ) {
        if (!p_331907_.isUpgrading()) {
            p_330441_.generator().spawnOriginalMobs(new WorldGenRegion(p_330441_.level(), p_331338_, p_332117_, -1));
        }

        return CompletableFuture.completedFuture(p_331907_);
    }

    static CompletableFuture<ChunkAccess> generateFull(
        WorldGenContext p_331852_, ChunkStatus p_330587_, Executor p_330464_, ToFullChunk p_332068_, List<ChunkAccess> p_332142_, ChunkAccess p_331010_
    ) {
        return p_332068_.apply(p_331010_);
    }

    static CompletableFuture<ChunkAccess> loadFull(WorldGenContext p_330444_, ChunkStatus p_331465_, ToFullChunk p_331298_, ChunkAccess p_330298_) {
        return p_331298_.apply(p_330298_);
    }
}
