package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class VoidPendantHasItemGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getBoolean("linked") == true) {
			return true;
		}
		return false;
	}
}
