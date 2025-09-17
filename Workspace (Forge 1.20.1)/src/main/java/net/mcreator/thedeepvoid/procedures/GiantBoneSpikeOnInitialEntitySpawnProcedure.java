package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.GiantBoneSpikeEntity;

public class GiantBoneSpikeOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GiantBoneSpikeEntity) {
			((GiantBoneSpikeEntity) entity).setAnimation("animation.giantSpike_spawn");
		}
	}
}
