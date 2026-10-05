
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.sombrius.thedeepvoid.init;

import net.sombrius.thedeepvoid.client.gui.VoidBagGuiScreen;
import net.sombrius.thedeepvoid.client.gui.UndertakerTradeGuiScreen;
import net.sombrius.thedeepvoid.client.gui.SoulForgeGUIScreen;
import net.sombrius.thedeepvoid.client.gui.NecrosedSkinBackpackGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheDeepVoidModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TheDeepVoidModMenus.VOID_BAG_GUI.get(), VoidBagGuiScreen::new);
			MenuScreens.register(TheDeepVoidModMenus.SOUL_FORGE_GUI.get(), SoulForgeGUIScreen::new);
			MenuScreens.register(TheDeepVoidModMenus.NECROSED_SKIN_BACKPACK_GUI.get(), NecrosedSkinBackpackGUIScreen::new);
			MenuScreens.register(TheDeepVoidModMenus.UNDERTAKER_TRADE_GUI.get(), UndertakerTradeGuiScreen::new);
		});
	}
}
