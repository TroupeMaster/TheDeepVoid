package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class BlackHoleStopUsingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("blackHoleLoading", false);
		entity.getPersistentData().putDouble("blackHolePulling", 0);
	}
}
