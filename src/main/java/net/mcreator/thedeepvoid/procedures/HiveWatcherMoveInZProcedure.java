package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class HiveWatcherMoveInZProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("speedBuildUp", 0);
		entity.getPersistentData().putBoolean("damageZ", true);
		if (Math.random() < 0.5) {
			if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1)).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 2)).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 3)).canOcclude()) {
				entity.getPersistentData().putBoolean("positive", true);
			} else {
				entity.getPersistentData().putBoolean("positive", false);
			}
		} else {
			if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1)).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 2)).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 3)).canOcclude()) {
				entity.getPersistentData().putBoolean("positive", false);
			} else {
				entity.getPersistentData().putBoolean("positive", true);
			}
		}
	}
}
