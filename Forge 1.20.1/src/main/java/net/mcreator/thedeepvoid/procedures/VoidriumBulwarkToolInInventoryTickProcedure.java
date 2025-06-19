package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class VoidriumBulwarkToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("deep_void:parryTime") > 0) {
			itemstack.getOrCreateTag().putDouble("deep_void:parryTime", (itemstack.getOrCreateTag().getDouble("deep_void:parryTime") - 1));
		}
	}
}
