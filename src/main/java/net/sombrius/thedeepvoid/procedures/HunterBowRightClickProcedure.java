package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class HunterBowRightClickProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("loading", true);
	}
}
