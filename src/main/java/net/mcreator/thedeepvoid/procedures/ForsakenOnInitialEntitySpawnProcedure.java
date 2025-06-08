package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class ForsakenOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("deep_void:hide", true);
	}
}
