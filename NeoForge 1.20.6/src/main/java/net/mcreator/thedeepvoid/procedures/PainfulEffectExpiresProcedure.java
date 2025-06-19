package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class PainfulEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("deep_void:advancedPainful") == true) {
			entity.getPersistentData().putBoolean("deep_void:advancedPainful", false);
		}
	}
}
