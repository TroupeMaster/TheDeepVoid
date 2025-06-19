package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.DoomingTombstoneEntity;

public class DoomingTombstoneOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DoomingTombstoneEntity) {
			((DoomingTombstoneEntity) entity).setAnimation("animation.tombstone_fall");
		}
	}
}
