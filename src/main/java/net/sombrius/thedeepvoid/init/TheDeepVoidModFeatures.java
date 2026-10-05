
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sombrius.thedeepvoid.init;

import net.sombrius.thedeepvoid.world.features.RottenMossGenerateNormalFeature;
import net.sombrius.thedeepvoid.world.features.RottenMossGenerateFeature;
import net.sombrius.thedeepvoid.world.features.HuntersCabinFeature;
import net.sombrius.thedeepvoid.world.features.FleshyFormationUndergroundFeature;
import net.sombrius.thedeepvoid.world.features.FleshMouthFeature;
import net.sombrius.thedeepvoid.world.features.FleshBlockGenerateNormalFeature;
import net.sombrius.thedeepvoid.world.features.CrumblingBedrockGenerateFeature;
import net.sombrius.thedeepvoid.TheDeepVoidMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

@Mod.EventBusSubscriber
public class TheDeepVoidModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TheDeepVoidMod.MODID);
	public static final RegistryObject<Feature<?>> ROTTEN_MOSS_GENERATE = REGISTRY.register("rotten_moss_generate", RottenMossGenerateFeature::new);
	public static final RegistryObject<Feature<?>> FLESH_MOUTH = REGISTRY.register("flesh_mouth", FleshMouthFeature::new);
	public static final RegistryObject<Feature<?>> FLESHY_FORMATION_UNDERGROUND = REGISTRY.register("fleshy_formation_underground", FleshyFormationUndergroundFeature::new);
	public static final RegistryObject<Feature<?>> ROTTEN_MOSS_GENERATE_NORMAL = REGISTRY.register("rotten_moss_generate_normal", RottenMossGenerateNormalFeature::new);
	public static final RegistryObject<Feature<?>> FLESH_BLOCK_GENERATE_NORMAL = REGISTRY.register("flesh_block_generate_normal", FleshBlockGenerateNormalFeature::new);
	public static final RegistryObject<Feature<?>> CRUMBLING_BEDROCK_GENERATE = REGISTRY.register("crumbling_bedrock_generate", CrumblingBedrockGenerateFeature::new);
	public static final RegistryObject<Feature<?>> HUNTERS_CABIN = REGISTRY.register("hunters_cabin", HuntersCabinFeature::new);
}
