package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class MaggotEntityVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getPersistentData().getDouble("growth") >= 6 && entity.getPersistentData().getDouble("growth") < 14) {
			return 1.25;
		} else if (entity.getPersistentData().getDouble("growth") >= 14 && entity.getPersistentData().getDouble("growth") < 28) {
			return 1.5;
		} else if (entity.getPersistentData().getDouble("growth") >= 28) {
			return 1.75;
		}
		return 1;
	}
}
