package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class VoidBowInInventoryProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) && entity.getPersistentData().getDouble("voidBowPulling") > 0) {
			entity.getPersistentData().putDouble("voidBowPulling", 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity.getPersistentData().getBoolean("voidBowLoading") == true) {
				if ((entity instanceof LivingEntity _entUseItem12 ? _entUseItem12.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem() && entity.getPersistentData().getDouble("voidBowPulling") < 60) {
					entity.getPersistentData().putDouble("voidBowPulling", (entity.getPersistentData().getDouble("voidBowPulling") + 1));
				}
			} else {
				entity.getPersistentData().putBoolean("voidBowLoading", false);
				entity.getPersistentData().putDouble("voidBowPulling", 0);
			}
		}
	}
}
