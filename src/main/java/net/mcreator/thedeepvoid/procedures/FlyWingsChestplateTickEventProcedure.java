package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

public class FlyWingsChestplateTickEventProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("flying") == true && entity.getPersistentData().getBoolean("flyWingsTouchGround") == true) {
			if (itemstack.getOrCreateTag().getDouble("time") > 0) {
				if (itemstack.getOrCreateTag().getBoolean("up") == true) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 1, (entity.getDeltaMovement().z())));
				} else if (itemstack.getOrCreateTag().getBoolean("down") == true) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-1), (entity.getDeltaMovement().z())));
				} else if (itemstack.getOrCreateTag().getBoolean("foward") == true) {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 0, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
				} else if (itemstack.getOrCreateTag().getBoolean("backward") == true) {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-1)), 0, (Math.cos(Math.toRadians(entity.getYRot())) * (-1))));
				} else {
					entity.setDeltaMovement(new Vec3(0, 0, 0));
				}
				if (Math.random() < 0.001) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				itemstack.getOrCreateTag().putDouble("time", (itemstack.getOrCreateTag().getDouble("time") - 1));
			} else if (entity.getPersistentData().getBoolean("flyWingsTouchGround") == true) {
				entity.getPersistentData().putBoolean("flyWingsTouchGround", false);
				itemstack.getOrCreateTag().putBoolean("foward", false);
				itemstack.getOrCreateTag().putBoolean("backward", false);
				itemstack.getOrCreateTag().putBoolean("up", false);
				itemstack.getOrCreateTag().putBoolean("down", false);
			}
		}
	}
}
