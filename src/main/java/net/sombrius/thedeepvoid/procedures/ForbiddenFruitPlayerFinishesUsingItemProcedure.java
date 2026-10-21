package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class ForbiddenFruitPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("tastedForbiddenFruit") == false) {
			entity.getPersistentData().putBoolean("tastedForbiddenFruit", true);
		}
	}
}
