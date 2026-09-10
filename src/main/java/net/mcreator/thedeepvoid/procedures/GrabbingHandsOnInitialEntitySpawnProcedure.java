package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.GrabbingHandsEntity;

public class GrabbingHandsOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GrabbingHandsEntity) {
			((GrabbingHandsEntity) entity).setAnimation("animation.hands_appear");
		}
	}
}
