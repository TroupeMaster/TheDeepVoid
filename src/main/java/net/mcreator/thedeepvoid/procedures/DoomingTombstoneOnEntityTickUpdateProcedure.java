package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.DoomingTombstoneEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class DoomingTombstoneOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheDeepVoidMod.queueServerWork(200, () -> {
			if (entity.getPersistentData().getBoolean("deep_void:despawning") == false) {
				entity.getPersistentData().putBoolean("deep_void:despawning", true);
				if (entity instanceof DoomingTombstoneEntity) {
					((DoomingTombstoneEntity) entity).setAnimation("animation.tombstone_despawn");
				}
			}
		});
		TheDeepVoidMod.queueServerWork(220, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
