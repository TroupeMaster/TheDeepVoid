package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class SoulOrbDisplayCondition1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.isPassenger()) {
			return true;
		}
		return false;
	}
}
