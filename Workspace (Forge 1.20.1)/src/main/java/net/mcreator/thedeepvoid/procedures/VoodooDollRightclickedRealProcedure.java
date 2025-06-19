package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;

public class VoodooDollRightclickedRealProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("deep_void:rightClicking", true);
	}
}
