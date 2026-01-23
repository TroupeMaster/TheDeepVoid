package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class PrisonGuardEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.2 && entity.getPersistentData().getDouble("jumpCooldown") > 0) {
			entity.getPersistentData().putDouble("jumpCooldown", 0);
		} else if (Math.random() < 0.2 && entity.getPersistentData().getDouble("rollCooldown") > 0) {
			entity.getPersistentData().putDouble("rollCooldown", 0);
		}
	}
}
