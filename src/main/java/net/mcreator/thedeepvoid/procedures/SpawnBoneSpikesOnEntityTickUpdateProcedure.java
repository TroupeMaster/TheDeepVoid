package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.SpawnBoneSpikesEntity;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class SpawnBoneSpikesOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof SpawnBoneSpikesEntity _datEntI ? _datEntI.getEntityData().get(SpawnBoneSpikesEntity.DATA_spawnSpike) : 0) <= 0) {
			if (entity instanceof SpawnBoneSpikesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SpawnBoneSpikesEntity.DATA_spawnSpike, (int) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIKEFREQUENCY.get());
			if (!(!world.getEntitiesOfClass(HiveWatcherEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 2, 2, 2), e -> true).isEmpty())) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.BONE_BLOCKADE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		} else {
			if (entity instanceof SpawnBoneSpikesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SpawnBoneSpikesEntity.DATA_spawnSpike, (int) ((entity instanceof SpawnBoneSpikesEntity _datEntI ? _datEntI.getEntityData().get(SpawnBoneSpikesEntity.DATA_spawnSpike) : 0) - 1));
		}
		TheDeepVoidMod.queueServerWork((int) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIKEDURATION.get(), () -> {
			if (!world.getEntitiesOfClass(SpawnBoneSpikesEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 1, 1, 1), e -> true).isEmpty()) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		});
	}
}
