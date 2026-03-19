package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class VoidBowRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("voidBowLoading", true);
	}
}
