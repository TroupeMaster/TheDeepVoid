package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.DoomingCoffinEntity;

import net.minecraft.world.entity.Entity;

public class DoomingCoffinSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DoomingCoffinEntity) {
			((DoomingCoffinEntity) entity).setAnimation("animation.coffin_fall");
		}
	}
}
