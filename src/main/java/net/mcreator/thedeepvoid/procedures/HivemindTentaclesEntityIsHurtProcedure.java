package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.HivemindTentaclesEntity;

public class HivemindTentaclesEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HivemindTentaclesEntity) {
			((HivemindTentaclesEntity) entity).setAnimation("animation.fleshTentacles_hurt");
		}
	}
}
