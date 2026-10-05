package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class BlackHoleStopUsingProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("loading", false);
		itemstack.getOrCreateTag().putDouble("pulling", 0);
	}
}
