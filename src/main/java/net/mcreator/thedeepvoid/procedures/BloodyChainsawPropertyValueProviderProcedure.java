package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class BloodyChainsawPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("state");
	}
}
