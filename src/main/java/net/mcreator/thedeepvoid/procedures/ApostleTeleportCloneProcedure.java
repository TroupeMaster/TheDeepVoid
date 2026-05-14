package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ApostleTeleportCloneProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ApostleBossEntity _datEntSetL)
			_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, true);
		if (entity instanceof ApostleBossEntity) {
			((ApostleBossEntity) entity).setAnimation("empty");
		}
		if (entity instanceof ApostleBossEntity) {
			((ApostleBossEntity) entity).setAnimation("animation.apostle_bow");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 99));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 1));
		if (entity instanceof ApostleBossEntity _datEntSetI)
			_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_tpTries, 0);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 1, (float) 0.8);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 1, (float) 0.8, false);
			}
		}
		for (int index0 = 0; index0 < 3; index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.APOSTLE_CLONE.get().spawn(_level, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -1, 1), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)),
						MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			TheDeepVoidMod.queueServerWork(10, () -> {
				while ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_tpTries) : 0) < 100) {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						if (entity instanceof ApostleBossEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_xPos, (int) ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -8, 8)));
						if (entity instanceof ApostleBossEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_yPos, (int) ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + Mth.nextInt(RandomSource.create(), 0, 2)));
						if (entity instanceof ApostleBossEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_zPos, (int) ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -8, 8)));
						if (world
								.isEmptyBlock(BlockPos.containing(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_xPos) : 0,
										entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_yPos) : 0,
										entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_zPos) : 0))
								&& world.isEmptyBlock(BlockPos.containing(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_xPos) : 0,
										(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_yPos) : 0) + 1,
										entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_zPos) : 0))
								&& world.isEmptyBlock(BlockPos.containing(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_xPos) : 0,
										(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_yPos) : 0) + 2,
										entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_zPos) : 0))
								&& world.getBlockState(BlockPos.containing(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_xPos) : 0,
										(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_yPos) : 0) - 1,
										entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_zPos) : 0)).canOcclude()) {
							{
								Entity _ent = entity;
								_ent.teleportTo((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_xPos) : 0),
										(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_yPos) : 0),
										(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_zPos) : 0));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_xPos) : 0),
											(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_yPos) : 0),
											(entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_zPos) : 0), _ent.getYRot(), _ent.getXRot());
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2,
											(float) 0.8);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.8, false);
								}
							}
							if (entity instanceof ApostleBossEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_tpTries, 101);
						}
					}
					if (entity instanceof ApostleBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_tpTries, (int) ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_tpTries) : 0) + 1));
				}
				if (entity instanceof ApostleBossEntity) {
					((ApostleBossEntity) entity).setAnimation("empty");
				}
			});
			if (entity instanceof ApostleBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, false);
		} else {
			if (entity instanceof ApostleBossEntity) {
				((ApostleBossEntity) entity).setAnimation("empty");
			}
			if (entity instanceof ApostleBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, false);
		}
		TheDeepVoidMod.queueServerWork(11, () -> {
			if (entity instanceof ApostleBossEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_attackChance, (int) ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_attackChance) : 0) + 10));
			if (entity instanceof ApostleBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, false);
			if (Math.random() < 0.8 && (entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_teleportCount) : 0) < (double) DeepVoidConfigConfiguration.APOSTLETELEPORTCOUNT.get()) {
				ApostleTeleportCloneProcedure.execute(world, entity);
				if (entity instanceof ApostleBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ApostleBossEntity.DATA_teleportCount, (int) ((entity instanceof ApostleBossEntity _datEntI ? _datEntI.getEntityData().get(ApostleBossEntity.DATA_teleportCount) : 0) + 1));
			}
		});
	}
}
