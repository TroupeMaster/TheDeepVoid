
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
import net.mcreator.thedeepvoid.enchantment.RadianceEnchantment;
import net.mcreator.thedeepvoid.enchantment.NecrosedEnchantment;
import net.mcreator.thedeepvoid.enchantment.CurseOfSorrowEnchantment;
import net.mcreator.thedeepvoid.enchantment.CurseOfGodsBloodEnchantment;
import net.mcreator.thedeepvoid.enchantment.CrateCatcherEnchantment;
import net.mcreator.thedeepvoid.enchantment.ConservationEnchantment;
import net.mcreator.thedeepvoid.enchantment.BoneWalkerEnchantment;
import net.mcreator.thedeepvoid.enchantment.BaitEnchantment;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TheDeepVoidMod.MODID);
	public static final RegistryObject<Enchantment> VOID_VISION = REGISTRY.register("void_vision", () -> new VoidVisionEnchantment());
	public static final RegistryObject<Enchantment> NECROSED = REGISTRY.register("necrosed", () -> new NecrosedEnchantment());
	public static final RegistryObject<Enchantment> SCOURGE_OF_FLESH = REGISTRY.register("scourge_of_flesh", () -> new ScourgeOfFleshEnchantment());
	public static final RegistryObject<Enchantment> BONE_WALKER = REGISTRY.register("bone_walker", () -> new BoneWalkerEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_SORROW = REGISTRY.register("curse_of_sorrow", () -> new CurseOfSorrowEnchantment());
	public static final RegistryObject<Enchantment> CRATE_CATCHER = REGISTRY.register("crate_catcher", () -> new CrateCatcherEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_GODS_BLOOD = REGISTRY.register("curse_of_gods_blood", () -> new CurseOfGodsBloodEnchantment());
	public static final RegistryObject<Enchantment> BAIT = REGISTRY.register("bait", () -> new BaitEnchantment());
	public static final RegistryObject<Enchantment> RADIANCE = REGISTRY.register("radiance", () -> new RadianceEnchantment());
	public static final RegistryObject<Enchantment> CONSERVATION = REGISTRY.register("conservation", () -> new ConservationEnchantment());
}
