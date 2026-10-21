
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.sombrius.thedeepvoid.init;

import net.sombrius.thedeepvoid.enchantment.VoidVisionEnchantment;
import net.sombrius.thedeepvoid.enchantment.ScourgeOfFleshEnchantment;
import net.sombrius.thedeepvoid.enchantment.RadianceEnchantment;
import net.sombrius.thedeepvoid.enchantment.QuickTriggerEnchantment;
import net.sombrius.thedeepvoid.enchantment.PointBlankEnchantment;
import net.sombrius.thedeepvoid.enchantment.NecrosedEnchantment;
import net.sombrius.thedeepvoid.enchantment.MarksmanEnchantment;
import net.sombrius.thedeepvoid.enchantment.DimensionalBurstEnchantment;
import net.sombrius.thedeepvoid.enchantment.CurseOfSorrowEnchantment;
import net.sombrius.thedeepvoid.enchantment.CurseOfGodsBloodEnchantment;
import net.sombrius.thedeepvoid.enchantment.CurseOfBloodMendingEnchantment;
import net.sombrius.thedeepvoid.enchantment.CrateCatcherEnchantment;
import net.sombrius.thedeepvoid.enchantment.ConservationEnchantment;
import net.sombrius.thedeepvoid.enchantment.BoneWalkerEnchantment;
import net.sombrius.thedeepvoid.enchantment.BaitEnchantment;
import net.sombrius.thedeepvoid.enchantment.AkimboEnchantment;
import net.sombrius.thedeepvoid.TheDeepVoidMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

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
	public static final RegistryObject<Enchantment> DIMENSIONAL_BURST = REGISTRY.register("dimensional_burst", () -> new DimensionalBurstEnchantment());
	public static final RegistryObject<Enchantment> QUICK_TRIGGER = REGISTRY.register("quick_trigger", () -> new QuickTriggerEnchantment());
	public static final RegistryObject<Enchantment> MARKSMAN = REGISTRY.register("marksman", () -> new MarksmanEnchantment());
	public static final RegistryObject<Enchantment> AKIMBO = REGISTRY.register("akimbo", () -> new AkimboEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_BLOOD_MENDING = REGISTRY.register("curse_of_blood_mending", () -> new CurseOfBloodMendingEnchantment());
	public static final RegistryObject<Enchantment> POINT_BLANK = REGISTRY.register("point_blank", () -> new PointBlankEnchantment());
}
