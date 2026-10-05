package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ManiacEntity;

import net.minecraft.world.entity.Entity;

public class ManiacAttackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof ManiacEntity _datEntL0 && _datEntL0.getEntityData().get(ManiacEntity.DATA_attacking)) == true) {
			return false;
		}
		return true;
	}
}
