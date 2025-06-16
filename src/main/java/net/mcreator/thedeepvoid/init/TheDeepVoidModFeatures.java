
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.thedeepvoid.world.features.FleshyFormationUndergroundFeature;
import net.mcreator.thedeepvoid.world.features.FleshMouthFeature;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

@Mod.EventBusSubscriber
public class TheDeepVoidModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TheDeepVoidMod.MODID);
	public static final RegistryObject<Feature<?>> FLESH_MOUTH = REGISTRY.register("flesh_mouth", FleshMouthFeature::new);
	public static final RegistryObject<Feature<?>> FLESHY_FORMATION_UNDERGROUND = REGISTRY.register("fleshy_formation_underground", FleshyFormationUndergroundFeature::new);
}
