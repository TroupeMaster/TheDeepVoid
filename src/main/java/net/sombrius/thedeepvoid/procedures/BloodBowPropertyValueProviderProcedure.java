package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class BloodBowPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("pulling") / 22;
	}
}
