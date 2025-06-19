
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, TheDeepVoidMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BROKEN_BONE = REGISTRY.register("broken_bone", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DARK_TEAR = REGISTRY.register("dark_tear", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EYE = REGISTRY.register("eye", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LICKER_TONGUE = REGISTRY.register("licker_tongue", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PUS_SPORE = REGISTRY.register("pus_spore", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DEEPSLATE_PEBBLE = REGISTRY.register("deepslate_pebble", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PENTAGRAM = REGISTRY.register("pentagram", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLY = REGISTRY.register("fly", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD = REGISTRY.register("blood", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GRIM_SWEEP = REGISTRY.register("grim_sweep", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHADE_DROP = REGISTRY.register("shade_drop", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAME_OF_SPITE = REGISTRY.register("flame_of_spite", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLACK_TENTACLE = REGISTRY.register("black_tentacle", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SOUL_SWEEP = REGISTRY.register("soul_sweep", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GOLD_BLOOD = REGISTRY.register("gold_blood", () -> new SimpleParticleType(false));
}
