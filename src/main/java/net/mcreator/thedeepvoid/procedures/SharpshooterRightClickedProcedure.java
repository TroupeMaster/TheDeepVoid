package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class SharpshooterRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("skullBowLoading", true);
	}
}
