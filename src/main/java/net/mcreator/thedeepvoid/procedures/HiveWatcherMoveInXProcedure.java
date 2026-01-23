package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class HiveWatcherMoveInXProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("speedBuildUp", 0);
		entity.getPersistentData().putBoolean("damageX", true);
		if (Math.random() < 0.5) {
			if (world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ())).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX() - 2, entity.getY(), entity.getZ())).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX() - 3, entity.getY(), entity.getZ())).canOcclude()) {
				entity.getPersistentData().putBoolean("positive", true);
			} else {
				entity.getPersistentData().putBoolean("positive", false);
			}
		} else {
			if (world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ())).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX() + 2, entity.getY(), entity.getZ())).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX() + 3, entity.getY(), entity.getZ())).canOcclude()) {
				entity.getPersistentData().putBoolean("positive", false);
			} else {
				entity.getPersistentData().putBoolean("positive", true);
			}
		}
	}
}
