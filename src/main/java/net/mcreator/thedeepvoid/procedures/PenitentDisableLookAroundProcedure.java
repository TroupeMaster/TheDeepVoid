package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class PenitentDisableLookAroundProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("praying") == false) {
			return true;
		}
		return false;
	}
}
