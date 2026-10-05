package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.WeaverOfSoulsBossEntity;

import net.minecraft.world.entity.Entity;

public class WeaverOfSoulsSolidBoundingBoxConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof WeaverOfSoulsBossEntity _datEntL0 && _datEntL0.getEntityData().get(WeaverOfSoulsBossEntity.DATA_stunned)) == false) {
			return true;
		}
		return false;
	}
}
