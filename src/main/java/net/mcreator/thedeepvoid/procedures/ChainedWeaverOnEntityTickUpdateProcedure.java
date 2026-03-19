package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ChainedWeaverOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 99, false, false));
		if ((entity instanceof ChainedWeaverEntity _datEntL1 && _datEntL1.getEntityData().get(ChainedWeaverEntity.DATA_free)) == true) {
			if ((entity instanceof ChainedWeaverEntity _datEntL2 && _datEntL2.getEntityData().get(ChainedWeaverEntity.DATA_playingAnimation)) == false) {
				if (entity instanceof ChainedWeaverEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ChainedWeaverEntity.DATA_playingAnimation, true);
				if (entity instanceof ChainedWeaverEntity) {
					((ChainedWeaverEntity) entity).setAnimation("animation.chainedWeaver_getOut");
				}
				TheDeepVoidMod.queueServerWork(170, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WEAVER_OF_SOULS_BOSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_scream")), SoundSource.HOSTILE, 4, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_scream")), SoundSource.HOSTILE, 4, 1, false);
						}
					}
				});
			}
		}
		if ((entity instanceof ChainedWeaverEntity _datEntL9 && _datEntL9.getEntityData().get(ChainedWeaverEntity.DATA_playingAnimation)) == true) {
			if (Math.random() < 0.02) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.HOSTILE, 4, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break")), SoundSource.HOSTILE, 4, (float) 0.8, false);
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 55, 55, 55), e -> true).isEmpty()) {
			if ((entity instanceof ChainedWeaverEntity _datEntL12 && _datEntL12.getEntityData().get(ChainedWeaverEntity.DATA_message)) == false
					&& (entity instanceof ChainedWeaverEntity _datEntL13 && _datEntL13.getEntityData().get(ChainedWeaverEntity.DATA_talking)) == false) {
				if (entity instanceof ChainedWeaverEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ChainedWeaverEntity.DATA_message, true);
				if (entity instanceof ChainedWeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ChainedWeaverEntity.DATA_messageCount, 200);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(55 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.weaver_of_souls.ambient1").getString())), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.weaver_of_souls.ambient2").getString())), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.weaver_of_souls.ambient3").getString())), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else if (Math.random() < 0.25) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.weaver_of_souls.ambient4").getString())), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							} else {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.weaver_of_souls.ambient1").getString())), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1.4, entityiterator.getZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")), SoundSource.HOSTILE, (float) 0.5, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY() + 1.4), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient")),
												SoundSource.HOSTILE, (float) 0.5, 1, false);
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ChainedWeaverEntity _datEntL48 && _datEntL48.getEntityData().get(ChainedWeaverEntity.DATA_message)) == true) {
			if ((entity instanceof ChainedWeaverEntity _datEntI ? _datEntI.getEntityData().get(ChainedWeaverEntity.DATA_messageCount) : 0) > 0) {
				if (entity instanceof ChainedWeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ChainedWeaverEntity.DATA_messageCount, (int) ((entity instanceof ChainedWeaverEntity _datEntI ? _datEntI.getEntityData().get(ChainedWeaverEntity.DATA_messageCount) : 0) - 1));
			}
			if ((entity instanceof ChainedWeaverEntity _datEntI ? _datEntI.getEntityData().get(ChainedWeaverEntity.DATA_messageCount) : 0) <= 0) {
				if (entity instanceof ChainedWeaverEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ChainedWeaverEntity.DATA_message, false);
			}
		}
		entity.setDeltaMovement(new Vec3(0, 0, 0));
	}
}
