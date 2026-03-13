package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;

public class WeaverOfSoulsSolidBoundingBoxConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof WeaverOfSoulsEntity _datEntL0 && _datEntL0.getEntityData().get(WeaverOfSoulsEntity.DATA_stunned)) == false) {
			return true;
		}
		return false;
	}
}
