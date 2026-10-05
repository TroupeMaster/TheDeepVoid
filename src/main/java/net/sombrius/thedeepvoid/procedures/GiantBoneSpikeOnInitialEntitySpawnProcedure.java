package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.GiantBoneSpikeEntity;

import net.minecraft.world.entity.Entity;

public class GiantBoneSpikeOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GiantBoneSpikeEntity) {
			((GiantBoneSpikeEntity) entity).setAnimation("animation.giantSpike_spawn");
		}
	}
}
