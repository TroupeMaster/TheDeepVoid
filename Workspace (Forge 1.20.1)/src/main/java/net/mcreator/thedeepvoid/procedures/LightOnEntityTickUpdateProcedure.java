package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.ShadowEntity;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.DamnedEntity;
import net.mcreator.thedeepvoid.entity.CrossEyesEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class LightOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
		if (world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) == 0 && world.getBlockState(BlockPos.containing(x, y - 1, z)).getLightEmission(world, BlockPos.containing(x, y - 1, z)) == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, 99, false, false));
		if (DeepVoidConfigConfiguration.DESTROYLIGHTSOURCES.get() == true) {
			if (y <= 0) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
					if (entity.getPersistentData().getDouble("deep_void:shadowSpawn") >= 180) {
						entity.getPersistentData().putDouble("deep_void:shadowSpawn", 0);
						if (!(!world.getEntitiesOfClass(ShadowEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.SHADOW.get().spawn(_level, BlockPos.containing(x + 8 + Mth.nextInt(RandomSource.create(), 1, 4), y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.SHADOW.get().spawn(_level, BlockPos.containing(x - 8 + Mth.nextInt(RandomSource.create(), -4, -1), y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.SHADOW.get().spawn(_level, BlockPos.containing(x, y, z - 8 + Mth.nextInt(RandomSource.create(), -4, -1)), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.SHADOW.get().spawn(_level, BlockPos.containing(x, y, z + 8 + Mth.nextInt(RandomSource.create(), 1, 4)), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
					} else {
						entity.getPersistentData().putDouble("deep_void:shadowSpawn", (entity.getPersistentData().getDouble("deep_void:shadowSpawn") + 1));
					}
				}
			} else {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 180, 180, 180), e -> true).isEmpty()) {
					if (entity.getPersistentData().getDouble("deep_void:damnedSpawn") >= 240) {
						entity.getPersistentData().putDouble("deep_void:damnedSpawn", 0);
						if (!(!world.getEntitiesOfClass(DamnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())
								&& !(!world.getEntitiesOfClass(CrossEyesEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())
								&& !(!world.getEntitiesOfClass(FourEyesEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())
								&& !(!world.getEntitiesOfClass(MultipleEyesEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.DAMNED.get().spawn(_level, BlockPos.containing(x + 8 + Mth.nextInt(RandomSource.create(), 1, 4), y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.CROSS_EYES.get().spawn(_level, BlockPos.containing(x - 8 + Mth.nextInt(RandomSource.create(), -4, -1), y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.FOUR_EYES.get().spawn(_level, BlockPos.containing(x, y, z - 8 + Mth.nextInt(RandomSource.create(), -4, -1)), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.MULTIPLE_EYES.get().spawn(_level, BlockPos.containing(x, y, z + 8 + Mth.nextInt(RandomSource.create(), 1, 4)), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
					} else {
						entity.getPersistentData().putDouble("deep_void:damnedSpawn", (entity.getPersistentData().getDouble("deep_void:damnedSpawn") + 1));
					}
				}
			}
		}
	}
}
