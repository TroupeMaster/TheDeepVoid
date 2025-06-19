package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class WeaverOfSoulsSolidBoundingBoxConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("deep_void:stunned") == false) {
			return true;
		}
		return false;
	}
}
