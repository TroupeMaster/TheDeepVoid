package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsBossEntity;

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
