package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class SoulOrbBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.isPassenger()) {
			return 0.01;
		}
		return 1;
	}
}
