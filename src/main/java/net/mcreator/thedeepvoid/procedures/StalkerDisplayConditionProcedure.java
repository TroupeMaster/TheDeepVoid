package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.StalkerEntity;

public class StalkerDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_heartbeat) : 0) >= 43) {
			return true;
		}
		return false;
	}
}
