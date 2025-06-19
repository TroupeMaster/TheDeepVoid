
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, TheDeepVoidMod.MODID);
	public static final DeferredHolder<Potion, Potion> ROT_POTION = REGISTRY.register("rot_potion", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.ROT, 240, 0, false, true)));
}
