package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEntities;
import net.sombrius.thedeepvoid.TheDeepVoidMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
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
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = TheDeepVoidModEntities.WATCHER_TEETH.get().create(_serverLevel, null, null,
								BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos")), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (entityinstance instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y - 1, z + entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = TheDeepVoidModEntities.WATCHER_TEETH.get().create(_serverLevel, null, null,
								BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos")), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (entityinstance instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y - 1, z - entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z - entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = TheDeepVoidModEntities.WATCHER_TEETH.get().create(_serverLevel, null, null,
								BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos")), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (entityinstance instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
				}
				if (world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y - 1, z - entity.getPersistentData().getDouble("teethPos"))) > 0
						&& !(world.getBlockFloorHeight(BlockPos.containing(x - entity.getPersistentData().getDouble("teethPos"), y, z - entity.getPersistentData().getDouble("teethPos"))) > 0)) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entityinstance = TheDeepVoidModEntities.WATCHER_TEETH.get().create(_serverLevel, null, null,
								BlockPos.containing(x + entity.getPersistentData().getDouble("teethPos"), y, z + entity.getPersistentData().getDouble("teethPos")), MobSpawnType.MOB_SUMMONED, false, false);
						if (entityinstance != null) {
							entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (entityinstance instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
							_serverLevel.addFreshEntity(entityinstance);
						}
					}
				}
			});
			wait = wait + 2;
		}
	}
}
