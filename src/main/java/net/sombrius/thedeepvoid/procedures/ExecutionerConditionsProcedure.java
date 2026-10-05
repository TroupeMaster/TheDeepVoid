package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ExecutionerEntity;

import net.minecraft.world.entity.Entity;

public class ExecutionerConditionsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof ExecutionerEntity _datEntL0 && _datEntL0.getEntityData().get(ExecutionerEntity.DATA_asleep)) == true) {
			return false;
		}
		return true;
	}
}
