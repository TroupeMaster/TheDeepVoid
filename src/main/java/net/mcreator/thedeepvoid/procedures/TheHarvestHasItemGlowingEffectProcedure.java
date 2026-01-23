package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class TheHarvestHasItemGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("slash") >= 5) {
			return true;
		}
		return false;
	}
}
