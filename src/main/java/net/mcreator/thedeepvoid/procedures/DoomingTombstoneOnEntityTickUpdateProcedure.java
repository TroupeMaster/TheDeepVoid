package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.DoomingTombstoneEntity;

public class DoomingTombstoneOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DoomingTombstoneEntity _datEntSetI)
			_datEntSetI.getEntityData().set(DoomingTombstoneEntity.DATA_despawn, (int) ((entity instanceof DoomingTombstoneEntity _datEntI ? _datEntI.getEntityData().get(DoomingTombstoneEntity.DATA_despawn) : 0) + 1));
		if ((entity instanceof DoomingTombstoneEntity _datEntI ? _datEntI.getEntityData().get(DoomingTombstoneEntity.DATA_despawn) : 0) == 200) {
			if (entity.getPersistentData().getBoolean("deep_void:despawning") == false) {
				entity.getPersistentData().putBoolean("deep_void:despawning", true);
				if (entity instanceof DoomingTombstoneEntity) {
					((DoomingTombstoneEntity) entity).setAnimation("animation.tombstone_despawn");
				}
			}
		} else if ((entity instanceof DoomingTombstoneEntity _datEntI ? _datEntI.getEntityData().get(DoomingTombstoneEntity.DATA_despawn) : 0) >= 220) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
