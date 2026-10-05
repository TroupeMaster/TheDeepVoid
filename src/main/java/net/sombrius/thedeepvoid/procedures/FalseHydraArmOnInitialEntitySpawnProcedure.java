package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.FalseHydraArmEntity;

import net.minecraft.world.entity.Entity;

public class FalseHydraArmOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FalseHydraArmEntity) {
			((FalseHydraArmEntity) entity).setAnimation("animation.arm_spawn");
		}
	}
}
