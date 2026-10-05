package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.SulfurTntEntityEntity;

import net.minecraft.world.entity.Entity;

public class SulfurTntEntityDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_tick) : 0) >= 10) {
			return true;
		}
		return false;
	}
}
