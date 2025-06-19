
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.enchantment.VoidVisionEnchantment;
import net.mcreator.thedeepvoid.enchantment.ScourgeOfFleshEnchantment;
import net.mcreator.thedeepvoid.enchantment.NecrosedEnchantment;
import net.mcreator.thedeepvoid.enchantment.CurseOfSorrowEnchantment;
import net.mcreator.thedeepvoid.enchantment.BoneWalkerEnchantment;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, TheDeepVoidMod.MODID);
	public static final DeferredHolder<Enchantment, Enchantment> VOID_VISION = REGISTRY.register("void_vision", () -> new VoidVisionEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> NECROSED = REGISTRY.register("necrosed", () -> new NecrosedEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> SCOURGE_OF_FLESH = REGISTRY.register("scourge_of_flesh", () -> new ScourgeOfFleshEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> BONE_WALKER = REGISTRY.register("bone_walker", () -> new BoneWalkerEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> CURSE_OF_SORROW = REGISTRY.register("curse_of_sorrow", () -> new CurseOfSorrowEnchantment());
}
