package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.MultipleEyesEntity;
import net.mcreator.thedeepvoid.entity.FourEyesEntity;
import net.mcreator.thedeepvoid.entity.DamnedEntity;
import net.mcreator.thedeepvoid.entity.CrossEyesEntity;
import net.mcreator.thedeepvoid.entity.BigEyeEntity;

public class DamnedOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DamnedEntity) {
			if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.CROSS_EYES.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.BIG_EYE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.MULTIPLE_EYES.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.FOUR_EYES.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				if (entity instanceof DamnedEntity) {
					((DamnedEntity) entity).setAnimation("animation.damned_spawn");
				}
			}
		} else if (entity instanceof CrossEyesEntity) {
			if (entity instanceof CrossEyesEntity) {
				((CrossEyesEntity) entity).setAnimation("animation.crossEye_spawn");
			}
		} else if (entity instanceof BigEyeEntity) {
			if (entity instanceof BigEyeEntity) {
				((BigEyeEntity) entity).setAnimation("animation.bigEye_spawn");
			}
		} else if (entity instanceof MultipleEyesEntity) {
			if (entity instanceof MultipleEyesEntity) {
				((MultipleEyesEntity) entity).setAnimation("animation.multipleEyes_spawn");
			}
		} else if (entity instanceof FourEyesEntity) {
			if (entity instanceof FourEyesEntity) {
				((FourEyesEntity) entity).setAnimation("animation.fourEyes_spawn");
			}
		}
	}
}
