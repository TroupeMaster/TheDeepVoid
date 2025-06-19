
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.world.features.RottenMossGenerateNormalFeature;
import net.mcreator.thedeepvoid.world.features.RottenMossGenerateFeature;
import net.mcreator.thedeepvoid.world.features.FleshyFormationUndergroundFeature;
import net.mcreator.thedeepvoid.world.features.FleshMouthFeature;
import net.mcreator.thedeepvoid.world.features.FleshBlockGenerateNormalFeature;
import net.mcreator.thedeepvoid.world.features.FleshBlobsGenerateFeature;
import net.mcreator.thedeepvoid.world.features.DesolateSoilGenerateNormalFeature;
import net.mcreator.thedeepvoid.world.features.DesolateSoilGenerateFeature;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, TheDeepVoidMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> DESOLATE_SOIL_GENERATE = REGISTRY.register("desolate_soil_generate", DesolateSoilGenerateFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ROTTEN_MOSS_GENERATE = REGISTRY.register("rotten_moss_generate", RottenMossGenerateFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> FLESH_MOUTH = REGISTRY.register("flesh_mouth", FleshMouthFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> FLESH_BLOBS_GENERATE = REGISTRY.register("flesh_blobs_generate", FleshBlobsGenerateFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> FLESHY_FORMATION_UNDERGROUND = REGISTRY.register("fleshy_formation_underground", FleshyFormationUndergroundFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DESOLATE_SOIL_GENERATE_NORMAL = REGISTRY.register("desolate_soil_generate_normal", DesolateSoilGenerateNormalFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ROTTEN_MOSS_GENERATE_NORMAL = REGISTRY.register("rotten_moss_generate_normal", RottenMossGenerateNormalFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> FLESH_BLOCK_GENERATE_NORMAL = REGISTRY.register("flesh_block_generate_normal", FleshBlockGenerateNormalFeature::new);
}
