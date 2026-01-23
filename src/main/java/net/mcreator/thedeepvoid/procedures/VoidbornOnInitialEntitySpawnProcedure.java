package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class VoidbornOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("crouching", 1);
	}
}
