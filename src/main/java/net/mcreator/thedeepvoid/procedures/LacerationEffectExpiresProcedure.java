package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class LacerationEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("deep_void:laceration", 0);
	}
}
