package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEnchantments;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

public class BlackHoleCanUseRangedItemProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (EnchantmentHelper.getItemEnchantmentLevel(TheDeepVoidModEnchantments.DIMENSIONAL_BURST.get(), itemstack) != 0) {
			if (itemstack.getOrCreateTag().getDouble("ammo") >= (double) DeepVoidConfigConfiguration.BLACKHOLESTORELIMIT.get()) {
				return false;
			}
		}
		return true;
	}
}
