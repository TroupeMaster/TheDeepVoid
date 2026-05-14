package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.ExecutionerEntity;

public class ExecutionerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ExecutionerEntity) {
			((ExecutionerEntity) entity).setAnimation("animation.executioner_asleep");
		}
	}
}
