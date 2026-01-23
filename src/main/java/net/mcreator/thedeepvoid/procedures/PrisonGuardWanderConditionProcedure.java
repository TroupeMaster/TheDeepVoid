package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class PrisonGuardWanderConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("disableWander") == false) {
			return true;
		}
		return false;
	}
}
