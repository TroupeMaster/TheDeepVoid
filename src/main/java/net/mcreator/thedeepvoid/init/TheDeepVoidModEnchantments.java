
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.thedeepvoid.enchantment.VoidVisionEnchantment;
import net.mcreator.thedeepvoid.enchantment.ScourgeOfFleshEnchantment;
import net.mcreator.thedeepvoid.enchantment.NecrosedEnchantment;
import net.mcreator.thedeepvoid.enchantment.CurseOfSorrowEnchantment;
import net.mcreator.thedeepvoid.enchantment.BoneWalkerEnchantment;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TheDeepVoidMod.MODID);
	public static final RegistryObject<Enchantment> VOID_VISION = REGISTRY.register("void_vision", () -> new VoidVisionEnchantment());
	public static final RegistryObject<Enchantment> NECROSED = REGISTRY.register("necrosed", () -> new NecrosedEnchantment());
	public static final RegistryObject<Enchantment> SCOURGE_OF_FLESH = REGISTRY.register("scourge_of_flesh", () -> new ScourgeOfFleshEnchantment());
	public static final RegistryObject<Enchantment> BONE_WALKER = REGISTRY.register("bone_walker", () -> new BoneWalkerEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_SORROW = REGISTRY.register("curse_of_sorrow", () -> new CurseOfSorrowEnchantment());
}
