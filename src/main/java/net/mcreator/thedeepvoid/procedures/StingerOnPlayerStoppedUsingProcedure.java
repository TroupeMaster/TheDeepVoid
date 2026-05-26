package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class StingerOnPlayerStoppedUsingProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("rightClicked", false);
		itemstack.getOrCreateTag().putDouble("state", 0);
		itemstack.getOrCreateTag().putDouble("hit", 0);
	}
}
