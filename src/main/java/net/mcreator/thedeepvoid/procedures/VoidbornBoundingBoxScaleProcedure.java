package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class VoidbornBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getPersistentData().getBoolean("crouch") == true) {
			return 0.45;
		} else if (entity.getPersistentData().getBoolean("crouch") == false) {
			return 1;
		}
		return 1;
	}
}
