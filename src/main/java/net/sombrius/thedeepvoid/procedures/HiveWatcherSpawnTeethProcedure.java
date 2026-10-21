package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEntities;
import net.sombrius.thedeepvoid.TheDeepVoidMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class HiveWatcherSpawnTeethProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double wait = 0;
		entity.getPersistentData().putDouble("teethPos", 0);
		for (int index0 = 0; index0 < 12; index0++) {
			TheDeepVoidMod.queueServerWork((int) wait, () -> {
				entity.getPersistentData().putDouble("teethPos", (entity.getPersistentData().getDouble("teethPos") + 1.5));
				if (world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y - 1, z + entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y - 1, z + entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y - 1, z - entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z - entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z - entity.getPersistentData().getDouble("teethPos")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y - 1, z - entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z - entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z - entity.getPersistentData().getDouble("teethPos")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y - 1, z)) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z)) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y - 1, z)) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z)) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x, y - 1, z + entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x, y, z + entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x, y, z + entity.getPersistentData().getDouble("teethPos")), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x, y - 1, z - entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x, y, z - entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WATCHER_TEETH.get().spawn(_level, BlockPos.containing(x, y, z - entity.getPersistentData().getDouble("teethPos")), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			});
			wait = wait + 2;
		}
	}
}
