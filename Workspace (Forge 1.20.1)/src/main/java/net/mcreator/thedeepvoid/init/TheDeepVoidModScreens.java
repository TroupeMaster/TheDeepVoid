
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.thedeepvoid.client.gui.VoidBagGuiScreen;
import net.mcreator.thedeepvoid.client.gui.SoulForgeGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheDeepVoidModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TheDeepVoidModMenus.VOID_BAG_GUI.get(), VoidBagGuiScreen::new);
			MenuScreens.register(TheDeepVoidModMenus.SOUL_FORGE_GUI.get(), SoulForgeGUIScreen::new);
		});
	}
}
