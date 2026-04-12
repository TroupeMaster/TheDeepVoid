package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEnchantments;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

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
