package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class TombstoneToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("deep_void:doom") > 0) {
			if (itemstack.getOrCreateTag().getDouble("deep_void:doomCount") >= 120) {
				itemstack.getOrCreateTag().putDouble("deep_void:doomCount", 0);
				itemstack.getOrCreateTag().putDouble("deep_void:doom", 0);
			} else {
				itemstack.getOrCreateTag().putDouble("deep_void:doomCount", (itemstack.getOrCreateTag().getDouble("deep_void:doomCount") + 1));
			}
		}
	}
}
