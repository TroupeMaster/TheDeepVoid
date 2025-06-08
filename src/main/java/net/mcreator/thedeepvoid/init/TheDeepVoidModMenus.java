
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.thedeepvoid.world.inventory.VoidBagGuiMenu;
import net.mcreator.thedeepvoid.world.inventory.SoulForgeGUIMenu;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheDeepVoidMod.MODID);
	public static final RegistryObject<MenuType<VoidBagGuiMenu>> VOID_BAG_GUI = REGISTRY.register("void_bag_gui", () -> IForgeMenuType.create(VoidBagGuiMenu::new));
	public static final RegistryObject<MenuType<SoulForgeGUIMenu>> SOUL_FORGE_GUI = REGISTRY.register("soul_forge_gui", () -> IForgeMenuType.create(SoulForgeGUIMenu::new));
}
