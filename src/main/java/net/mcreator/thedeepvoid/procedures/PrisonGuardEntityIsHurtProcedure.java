package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.PrisonGuardEntity;

public class PrisonGuardEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.2 && (entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_jump) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_jump, 0);
		} else if (Math.random() < 0.2 && (entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_roll) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_roll, 0);
		}
	}
}
