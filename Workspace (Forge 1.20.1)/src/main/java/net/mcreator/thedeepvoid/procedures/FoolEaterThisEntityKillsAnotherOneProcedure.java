package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class FoolEaterThisEntityKillsAnotherOneProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity.getPersistentData().getBoolean("deep_void:cracked") == true) {
			sourceentity.getPersistentData().putBoolean("deep_void:cracked", false);
		}
	}
}
