package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ApostleCloneEntity;

import net.minecraft.world.entity.Entity;

public class ApostleCloneOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ApostleCloneEntity _datEntI ? _datEntI.getEntityData().get(ApostleCloneEntity.DATA_despawn) : 0) >= 15) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity instanceof ApostleCloneEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ApostleCloneEntity.DATA_despawn, (int) ((entity instanceof ApostleCloneEntity _datEntI ? _datEntI.getEntityData().get(ApostleCloneEntity.DATA_despawn) : 0) + 1));
		}
	}
}
