package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEntities;
import net.sombrius.thedeepvoid.entity.SpawnBoneSpikesEntity;
import net.sombrius.thedeepvoid.entity.HiveWatcherEntity;
import net.sombrius.thedeepvoid.entity.FleshWormEntity;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.sombrius.thedeepvoid.TheDeepVoidMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class SpawnBoneSpikesOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof SpawnBoneSpikesEntity _datEntI ? _datEntI.getEntityData().get(SpawnBoneSpikesEntity.DATA_spawnSpike) : 0) <= 0) {
			if (entity instanceof SpawnBoneSpikesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SpawnBoneSpikesEntity.DATA_spawnSpike, 5);
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
				if (!world.getEntitiesOfClass(FleshWormEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof FleshWormEntity) {
								{
									Entity _ent = entityiterator;
									_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
								}
							}
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
		});
	}
}
