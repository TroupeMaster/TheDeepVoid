
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.thedeepvoid.world.features.RottenMossGenerateNormalFeature;
import net.mcreator.thedeepvoid.world.features.RottenMossGenerateFeature;
import net.mcreator.thedeepvoid.world.features.FleshyFormationUndergroundFeature;
import net.mcreator.thedeepvoid.world.features.FleshMouthFeature;
import net.mcreator.thedeepvoid.world.features.FleshBlockGenerateNormalFeature;
import net.mcreator.thedeepvoid.world.features.FleshBlobsGenerateFeature;
import net.mcreator.thedeepvoid.world.features.DesolateSoilGenerateNormalFeature;
import net.mcreator.thedeepvoid.world.features.DesolateSoilGenerateFeature;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@Mod.EventBusSubscriber
public class TheDeepVoidModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TheDeepVoidMod.MODID);
	public static final RegistryObject<Feature<?>> DESOLATE_SOIL_GENERATE = REGISTRY.register("desolate_soil_generate", DesolateSoilGenerateFeature::new);
	public static final RegistryObject<Feature<?>> ROTTEN_MOSS_GENERATE = REGISTRY.register("rotten_moss_generate", RottenMossGenerateFeature::new);
	public static final RegistryObject<Feature<?>> FLESH_MOUTH = REGISTRY.register("flesh_mouth", FleshMouthFeature::new);
	public static final RegistryObject<Feature<?>> FLESH_BLOBS_GENERATE = REGISTRY.register("flesh_blobs_generate", FleshBlobsGenerateFeature::new);
	public static final RegistryObject<Feature<?>> FLESHY_FORMATION_UNDERGROUND = REGISTRY.register("fleshy_formation_underground", FleshyFormationUndergroundFeature::new);
	public static final RegistryObject<Feature<?>> DESOLATE_SOIL_GENERATE_NORMAL = REGISTRY.register("desolate_soil_generate_normal", DesolateSoilGenerateNormalFeature::new);
	public static final RegistryObject<Feature<?>> ROTTEN_MOSS_GENERATE_NORMAL = REGISTRY.register("rotten_moss_generate_normal", RottenMossGenerateNormalFeature::new);
	public static final RegistryObject<Feature<?>> FLESH_BLOCK_GENERATE_NORMAL = REGISTRY.register("flesh_block_generate_normal", FleshBlockGenerateNormalFeature::new);
}
