package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class KnivesGloveLivingEntityIsHitWithItemProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("state") < 3) {
			itemstack.getOrCreateTag().putDouble("state", (itemstack.getOrCreateTag().getDouble("state") + 1));
		}
	}
}
