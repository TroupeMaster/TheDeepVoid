package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.HarbingerCloneEntity;

public class HarbingerCloneOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof HarbingerCloneEntity _datEntI ? _datEntI.getEntityData().get(HarbingerCloneEntity.DATA_despawn) : 0) >= 15) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity instanceof HarbingerCloneEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HarbingerCloneEntity.DATA_despawn, (int) ((entity instanceof HarbingerCloneEntity _datEntI ? _datEntI.getEntityData().get(HarbingerCloneEntity.DATA_despawn) : 0) + 1));
		}
	}
}
