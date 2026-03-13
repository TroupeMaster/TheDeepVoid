package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class FlyWingsChestplateTouchGroundProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("flyWingsTouchGround") == false && entity.onGround()) {
			entity.getPersistentData().putBoolean("flyWingsTouchGround", true);
		}
	}
}
