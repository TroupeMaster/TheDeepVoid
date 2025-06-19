
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, TheDeepVoidMod.MODID);
	public static final RegistryObject<Potion> ROT_POTION = REGISTRY.register("rot_potion", () -> new Potion(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 240, 0, false, true)));
}
