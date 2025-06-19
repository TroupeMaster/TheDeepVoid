
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thedeepvoid.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thedeepvoid.client.gui.VoidBagGuiScreen;
import net.mcreator.thedeepvoid.client.gui.SoulForgeGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheDeepVoidModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(TheDeepVoidModMenus.VOID_BAG_GUI.get(), VoidBagGuiScreen::new);
		event.register(TheDeepVoidModMenus.SOUL_FORGE_GUI.get(), SoulForgeGUIScreen::new);
	}
}
