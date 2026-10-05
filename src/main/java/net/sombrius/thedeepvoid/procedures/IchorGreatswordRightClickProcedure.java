package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class IchorGreatswordRightClickProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("block", 1);
	}
}
