package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class StingerItemInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("dash") > 0) {
			itemstack.getOrCreateTag().putDouble("dash", (itemstack.getOrCreateTag().getDouble("dash") - 1));
		}
	}
}
