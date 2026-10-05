package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.HivemindTentaclesEntity;

import net.minecraft.world.entity.Entity;

public class HivemindTentaclesEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HivemindTentaclesEntity) {
			((HivemindTentaclesEntity) entity).setAnimation("animation.fleshTentacles_hurt");
		}
	}
}
