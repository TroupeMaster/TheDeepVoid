package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.FleshFangsEntity;

import net.minecraft.world.entity.Entity;

public class FleshFangsOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FleshFangsEntity) {
			((FleshFangsEntity) entity).setAnimation("animation.fleshFangs_appear");
		}
	}
}
