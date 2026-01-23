
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, TheDeepVoidMod.MODID);
	public static final RegistryObject<Potion> ROT_POTION = REGISTRY.register("rot_potion", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 460, 0, false, true)));
	public static final RegistryObject<Potion> VANISHMENT = REGISTRY.register("vanishment", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.VANISH.get(), 1200, 0, false, false),
			new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0, false, false), new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0, false, false)));
	public static final RegistryObject<Potion> LONG_VANISHMENT = REGISTRY.register("long_vanishment", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.VANISH.get(), 2400, 0, false, false),
			new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0, false, false), new MobEffectInstance(MobEffects.INVISIBILITY, 2400, 0, false, false)));
	public static final RegistryObject<Potion> ENHANCED_VANISHMENT = REGISTRY.register("enhanced_vanishment", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.VANISH.get(), 500, 0, false, false),
			new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 1, false, false), new MobEffectInstance(MobEffects.INVISIBILITY, 500, 0, false, false)));
	public static final RegistryObject<Potion> CRATE_MAGNET_POTION = REGISTRY.register("crate_magnet_potion", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.CRATE_MAGNET.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> EXTENDED_CRATE_MAGNET = REGISTRY.register("extended_crate_magnet", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.CRATE_MAGNET.get(), 9600, 0, false, true)));
	public static final RegistryObject<Potion> AMPLIFIED_CRATE_MAGNET = REGISTRY.register("amplified_crate_magnet", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.CRATE_MAGNET.get(), 1800, 1, false, true)));
	public static final RegistryObject<Potion> CREATURE_REPELLENT_POTION = REGISTRY.register("creature_repellent_potion", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.CREATURE_REPELLENT.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> EXTENDED_CREATURE_REPELLENT_POTION = REGISTRY.register("extended_creature_repellent_potion",
			() -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.CREATURE_REPELLENT.get(), 9600, 0, false, true)));
}
