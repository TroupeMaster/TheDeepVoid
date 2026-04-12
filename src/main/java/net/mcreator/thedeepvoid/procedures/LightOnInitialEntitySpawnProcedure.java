package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class LightOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
	}
}
