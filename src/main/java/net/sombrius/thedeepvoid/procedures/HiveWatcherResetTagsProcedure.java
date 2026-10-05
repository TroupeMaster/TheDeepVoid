package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class HiveWatcherResetTagsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("moveInPos", false);
		entity.getPersistentData().putDouble("stopMove", 0);
		entity.getPersistentData().putBoolean("moveInX", false);
		entity.getPersistentData().putBoolean("moveInZ", false);
		entity.getPersistentData().putBoolean("positive", false);
	}
}
