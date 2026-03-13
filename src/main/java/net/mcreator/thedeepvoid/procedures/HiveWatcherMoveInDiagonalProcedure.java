package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;

public class HiveWatcherMoveInDiagonalProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("speedBuildUp", 0);
		if (entity instanceof HiveWatcherEntity _datEntSetL)
			_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageX, true);
		if (entity instanceof HiveWatcherEntity _datEntSetL)
			_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageZ, true);
		if (Math.random() < 0.5) {
			if (world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ())).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX() - 2, entity.getY(), entity.getZ())).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX() - 3, entity.getY(), entity.getZ())).canOcclude()) {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive, true);
			} else {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive, false);
			}
		} else {
			if (world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ())).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX() + 2, entity.getY(), entity.getZ())).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX() + 3, entity.getY(), entity.getZ())).canOcclude()) {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive, false);
			} else {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive, true);
			}
		}
		if (Math.random() < 0.5) {
			if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1)).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 2)).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 3)).canOcclude()) {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive2, true);
			} else {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive2, false);
			}
		} else {
			if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1)).canOcclude() || world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 2)).canOcclude()
					|| world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 3)).canOcclude()) {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive2, false);
			} else {
				if (entity instanceof HiveWatcherEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_positive2, true);
			}
		}
	}
}
