package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class BuiltOverseerOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle()) {
			if (entity.getPersistentData().getBoolean("deep_void:overseerSaddle") == false) {
				if (!((entity.getFirstPassenger()) == null)) {
					(entity.getFirstPassenger()).stopRiding();
				}
			}
		}
	}
}
