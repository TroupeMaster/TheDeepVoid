package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class StalkerDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("Heartbeat") >= 43) {
			return true;
		}
		return false;
	}
}
