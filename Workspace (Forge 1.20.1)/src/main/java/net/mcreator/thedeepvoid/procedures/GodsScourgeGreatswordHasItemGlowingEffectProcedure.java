package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class GodsScourgeGreatswordHasItemGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("deep_void:soulAmount") >= 10) {
			return true;
		}
		return false;
	}
}
