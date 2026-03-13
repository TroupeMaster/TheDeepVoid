package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;

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
