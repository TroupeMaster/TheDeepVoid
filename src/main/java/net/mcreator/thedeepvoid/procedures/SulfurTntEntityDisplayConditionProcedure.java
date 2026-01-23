package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class SulfurTntEntityDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("tick") >= 10) {
			return true;
		}
		return false;
	}
}
