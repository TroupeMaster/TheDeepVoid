package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class GrimScytheHasItemGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("soul") >= 5) {
			return true;
		}
		return false;
	}
}
