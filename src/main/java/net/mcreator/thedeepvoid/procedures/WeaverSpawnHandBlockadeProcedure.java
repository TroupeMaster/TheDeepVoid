package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;

public class WeaverSpawnHandBlockadeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if ((entity instanceof WeaverOfSoulsEntity _datEntL2 && _datEntL2.getEntityData().get(WeaverOfSoulsEntity.DATA_blockade)) == false) {
				if (entity instanceof WeaverOfSoulsEntity _datEntSetL)
					_datEntSetL.getEntityData().set(WeaverOfSoulsEntity.DATA_blockade, true);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else if (Math.random() < 0.3) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else if (Math.random() < 0.3) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}
