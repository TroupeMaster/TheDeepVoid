package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class StalkerBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getPersistentData().getBoolean("deep_void:crouching") == true) {
			return 0.5;
		}
		return 1;
	}
}
