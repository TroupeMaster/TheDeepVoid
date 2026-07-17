package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.FalseHydraArmEntity;

public class FalseHydraArmOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FalseHydraArmEntity) {
			((FalseHydraArmEntity) entity).setAnimation("animation.arm_spawn");
		}
	}
}
