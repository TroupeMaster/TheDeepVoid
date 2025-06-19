
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.world.inventory.VoidBagGuiMenu;
import net.mcreator.thedeepvoid.world.inventory.SoulForgeGUIMenu;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class TheDeepVoidModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, TheDeepVoidMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<VoidBagGuiMenu>> VOID_BAG_GUI = REGISTRY.register("void_bag_gui", () -> IMenuTypeExtension.create(VoidBagGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SoulForgeGUIMenu>> SOUL_FORGE_GUI = REGISTRY.register("soul_forge_gui", () -> IMenuTypeExtension.create(SoulForgeGUIMenu::new));
}
