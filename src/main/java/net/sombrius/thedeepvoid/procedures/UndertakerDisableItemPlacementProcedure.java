package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;

import net.minecraft.world.item.ItemStack;

public class UndertakerDisableItemPlacementProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (!(itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_COIN.get()) && !(itemstack.getItem() == TheDeepVoidModItems.DARK_STEEL_SCRAP.get())) {
			return true;
		}
		return false;
	}
}
