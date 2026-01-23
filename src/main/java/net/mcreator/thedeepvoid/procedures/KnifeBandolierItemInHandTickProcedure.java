package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class KnifeBandolierItemInHandTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("count") < (double) DeepVoidConfigConfiguration.KNIFEBANDOLIERTIMEBEFORECHARGE.get()) {
			itemstack.getOrCreateTag().putDouble("count", (itemstack.getOrCreateTag().getDouble("count") + 1));
		}
	}
}
