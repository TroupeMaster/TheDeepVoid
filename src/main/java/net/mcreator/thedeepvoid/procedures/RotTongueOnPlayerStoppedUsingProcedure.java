package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class RotTongueOnPlayerStoppedUsingProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("block", 0);
	}
}
