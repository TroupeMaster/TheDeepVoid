package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.DoomingCoffinEntity;

public class DoomingCoffinSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DoomingCoffinEntity) {
			((DoomingCoffinEntity) entity).setAnimation("animation.coffin_fall");
		}
	}
}
