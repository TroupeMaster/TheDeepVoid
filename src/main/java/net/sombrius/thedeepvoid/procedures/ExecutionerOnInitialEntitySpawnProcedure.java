package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ExecutionerEntity;

import net.minecraft.world.entity.Entity;

public class ExecutionerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ExecutionerEntity) {
			((ExecutionerEntity) entity).setAnimation("animation.executioner_asleep");
		}
	}
}
