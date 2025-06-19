package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class SulfurTntEntityModelVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getPersistentData().getDouble("fuse") >= 1) {
			return 1.8;
		}
		return 1;
	}
}
