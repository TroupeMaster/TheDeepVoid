package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class SharpshooterValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("pulling") / 22;
	}
}
