package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class BabyBoneCrawlerNeutralEntityVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getPersistentData().getDouble("growth") >= 15 && entity.getPersistentData().getDouble("growth") < 35) {
			return 1.15;
		} else if (entity.getPersistentData().getDouble("growth") >= 35 && entity.getPersistentData().getDouble("growth") < 50) {
			return 1.22;
		} else if (entity.getPersistentData().getDouble("growth") >= 50) {
			return 1.3;
		}
		return 1;
	}
}
