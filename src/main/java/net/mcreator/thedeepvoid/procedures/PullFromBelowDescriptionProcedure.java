package net.mcreator.thedeepvoid.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

public class PullFromBelowDescriptionProcedure {
	public static String execute() {
		if (Screen.hasShiftDown()) {
			return "\u00A77" + Component.translatable("item.the_deep_void.pull_from_below.desc").getString();
		}
		return Component.translatable("item.the_deep_void.weapon_tooltip.show").getString();
	}
}
