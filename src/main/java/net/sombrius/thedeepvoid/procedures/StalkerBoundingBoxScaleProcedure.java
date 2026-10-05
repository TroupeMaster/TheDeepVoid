package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.StalkerEntity;

import net.minecraft.world.entity.Entity;

public class StalkerBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity instanceof StalkerEntity _datEntL0 && _datEntL0.getEntityData().get(StalkerEntity.DATA_crouching)) == true) {
			return 0.5;
		} else if ((entity instanceof StalkerEntity _datEntL1 && _datEntL1.getEntityData().get(StalkerEntity.DATA_crouching)) == false) {
			return 1;
		}
		return 1;
	}
}
