package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsBossEntity;

public class WeaverSpawnHandWallProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if ((entity instanceof WeaverOfSoulsBossEntity _datEntL2 && _datEntL2.getEntityData().get(WeaverOfSoulsBossEntity.DATA_stunned)) == false) {
				if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_handWall) : 0) >= 400) {
					if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_handWall, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sculk_shrieker.shriek")), SoundSource.HOSTILE, 4, (float) 0.8);
						} else {
							_level.playLocalSound((entity.getPersistentData().getDouble("deep_void:startingX")), (entity.getPersistentData().getDouble("deep_void:startingY")), (entity.getPersistentData().getDouble("deep_void:startingZ")),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sculk_shrieker.shriek")), SoundSource.HOSTILE, 4, (float) 0.8, false);
						}
					}
					if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_randomNumber, Mth.nextInt(RandomSource.create(), 1, 4));
					if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_randomNumber) : 0) == 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 2, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 4, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 8, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 10, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 12, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 14, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 16, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 18, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 20, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_randomNumber) : 0) == 2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 2, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 4, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 8, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 10, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 12, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 14, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 16, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 18, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 20, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_randomNumber) : 0) == 3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 2),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 4),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 8),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 10),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 12),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 14),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 16),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 18),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 20),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_randomNumber) : 0) == 4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 2),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 4),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 8),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 10),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 12),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 14),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 16),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 18),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 20),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				} else {
					if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_handWall, (int) ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_handWall) : 0) + 1));
				}
			}
		}
	}
}
