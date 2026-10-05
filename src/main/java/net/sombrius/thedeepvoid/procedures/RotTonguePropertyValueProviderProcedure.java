package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class RotTonguePropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("block");
	}
}
