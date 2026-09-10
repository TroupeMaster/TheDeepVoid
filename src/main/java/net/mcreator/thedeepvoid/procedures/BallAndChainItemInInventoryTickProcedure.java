package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class BallAndChainItemInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if ((itemstack.getDisplayName().getString()).contains("Rem's Morningstar") && itemstack.getOrCreateTag().getDouble("secret") == 0) {
			itemstack.getOrCreateTag().putDouble("secret", 1);
		} else if (!(itemstack.getDisplayName().getString()).contains("Rem's Morningstar") && itemstack.getOrCreateTag().getDouble("secret") == 1) {
			itemstack.getOrCreateTag().putDouble("secret", 0);
		}
	}
}
