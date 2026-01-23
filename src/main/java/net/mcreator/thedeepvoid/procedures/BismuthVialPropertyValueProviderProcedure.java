package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class BismuthVialPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("xp");
	}
}
