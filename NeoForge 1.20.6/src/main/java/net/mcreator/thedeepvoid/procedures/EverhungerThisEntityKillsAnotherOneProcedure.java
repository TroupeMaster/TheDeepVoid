package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class EverhungerThisEntityKillsAnotherOneProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("deep_void_alert", false);
	}
}
