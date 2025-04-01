package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class GhostlyNightmareOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheDeepVoidMod.queueServerWork(100, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
