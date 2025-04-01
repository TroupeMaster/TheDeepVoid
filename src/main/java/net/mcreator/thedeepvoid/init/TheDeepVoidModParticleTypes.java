
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TheDeepVoidMod.MODID);
	public static final RegistryObject<SimpleParticleType> BROKEN_BONE = REGISTRY.register("broken_bone", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DARK_TEAR = REGISTRY.register("dark_tear", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> EYE = REGISTRY.register("eye", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LICKER_TONGUE = REGISTRY.register("licker_tongue", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PUS_SPORE = REGISTRY.register("pus_spore", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DEEPSLATE_PEBBLE = REGISTRY.register("deepslate_pebble", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PENTAGRAM = REGISTRY.register("pentagram", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FLY = REGISTRY.register("fly", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> BLOOD = REGISTRY.register("blood", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> GRIM_SWEEP = REGISTRY.register("grim_sweep", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SHADE_DROP = REGISTRY.register("shade_drop", () -> new SimpleParticleType(false));
}
