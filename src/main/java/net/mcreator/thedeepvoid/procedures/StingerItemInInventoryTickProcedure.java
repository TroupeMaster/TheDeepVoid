package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class StingerItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("rightClicked") == true && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem())) {
			itemstack.getOrCreateTag().putBoolean("rightClicked", false);
			itemstack.getOrCreateTag().putDouble("state", 0);
			itemstack.getOrCreateTag().putDouble("hit", 0);
		}
	}
}
