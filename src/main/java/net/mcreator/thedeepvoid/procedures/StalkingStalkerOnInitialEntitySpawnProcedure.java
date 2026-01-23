package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class StalkingStalkerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("deep_void:despawnable", false);
		if (Math.random() < 0.5) {
			entity.getPersistentData().putBoolean("deep_void:stalkingShy", true);
		} else {
			entity.getPersistentData().putBoolean("deep_void:stalkingPhase", true);
		}
	}
}
