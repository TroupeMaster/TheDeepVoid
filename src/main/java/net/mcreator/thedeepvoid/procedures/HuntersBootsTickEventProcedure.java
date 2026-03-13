package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class HuntersBootsTickEventProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("doubleJump") == true) {
			if (entity.onGround()) {
				itemstack.getOrCreateTag().putBoolean("doubleJump", false);
			}
		}
	}
}
