package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.GrabbingHandsEntity;

import net.minecraft.world.entity.Entity;

public class GrabbingHandsOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GrabbingHandsEntity) {
			((GrabbingHandsEntity) entity).setAnimation("animation.hands_appear");
		}
	}
}
