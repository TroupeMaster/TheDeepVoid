package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class UndertakerDisableItemPlacementProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (!(itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_COIN.get()) && !(itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_SCRAP.get())) {
			return true;
		}
		return false;
	}
}
