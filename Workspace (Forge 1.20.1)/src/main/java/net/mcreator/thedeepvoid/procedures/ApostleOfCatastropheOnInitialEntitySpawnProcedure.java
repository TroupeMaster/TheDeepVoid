package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class ApostleOfCatastropheOnInitialEntitySpawnProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("deep_void:forgeX", x);
		entity.getPersistentData().putDouble("deep_void:forgeY", y);
		entity.getPersistentData().putDouble("deep_void:forgeZ", z);
	}
}
