package net.mcreator.thedeepvoid.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

public class PlagueDoctorGloveDescriptionProcedure {
	public static String execute() {
		if (Screen.hasShiftDown()) {
			return "\u00A77" + Component.translatable("item.the_deep_void.plague_doctor_glove.desc").getString();
		}
		return Component.translatable("item.the_deep_void.weapon_tooltip.show").getString();
	}
}
