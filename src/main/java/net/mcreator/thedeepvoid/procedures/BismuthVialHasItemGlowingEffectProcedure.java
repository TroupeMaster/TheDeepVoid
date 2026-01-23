package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class BismuthVialHasItemGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("xp") >= 1) {
			return true;
		}
		return false;
	}
}
