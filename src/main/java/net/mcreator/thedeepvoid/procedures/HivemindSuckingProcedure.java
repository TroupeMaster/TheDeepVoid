package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.SkullSmasherEntity;
import net.mcreator.thedeepvoid.entity.SawThrowerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.HivemindTentaclesEntity;
import net.mcreator.thedeepvoid.entity.FleshFangsEntity;
import net.mcreator.thedeepvoid.entity.BoneSawEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.List;
import java.util.Comparator;

public class HivemindSuckingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) == 10) {
				if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_attacking, false);
			} else if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) == 1) {
				if (entity instanceof MisanthropicHivemindEntity) {
					((MisanthropicHivemindEntity) entity).setAnimation("empty");
				}
				if ((entity instanceof MisanthropicHivemindEntity _datEntL5 && _datEntL5.getEntityData().get(MisanthropicHivemindEntity.DATA_digesting)) == true) {
					if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
						_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_digesting, false);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !(entityiterator instanceof SawThrowerEntity) && !(entityiterator instanceof BoneSawEntity) && !(entityiterator instanceof SkullSmasherEntity)
									&& !(entityiterator instanceof FleshFangsEntity) && !(entityiterator instanceof HivemindTentaclesEntity) && !(new Object() {
										public boolean checkGamemode(Entity _ent) {
											if (_ent instanceof ServerPlayer _serverPlayer) {
												return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
											} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
												return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
														&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
											}
											return false;
										}
									}.checkGamemode(entityiterator)) && !(new Object() {
										public boolean checkGamemode(Entity _ent) {
											if (_ent instanceof ServerPlayer _serverPlayer) {
												return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
											} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
												return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
														&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
											}
											return false;
										}
									}.checkGamemode(entityiterator)) && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
								entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 1, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")),
												SoundSource.HOSTILE, (float) 1.5, (float) 0.6);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, (float) 1.5,
												(float) 0.6, false);
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) == 140) {
				if (entity instanceof MisanthropicHivemindEntity) {
					((MisanthropicHivemindEntity) entity).setAnimation("animation.hivemind_suckWindup");
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_prepare_suck")), SoundSource.HOSTILE, (float) 2.5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_prepare_suck")), SoundSource.HOSTILE, (float) 2.5, 1, false);
					}
				}
			} else if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) <= 100
					&& (entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) > 1) {
				if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) == 100) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_suck")), SoundSource.HOSTILE, (float) 2.5, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_suck")), SoundSource.HOSTILE, (float) 2.5, 1, false);
						}
					}
				}
				if ((entity instanceof MisanthropicHivemindEntity _datEntL32 && _datEntL32.getEntityData().get(MisanthropicHivemindEntity.DATA_digesting)) == false) {
					if (entity instanceof MisanthropicHivemindEntity) {
						((MisanthropicHivemindEntity) entity).setAnimation("animation.hivemind_suck");
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !(entityiterator instanceof SawThrowerEntity) && !(entityiterator instanceof BoneSawEntity) && !(entityiterator instanceof SkullSmasherEntity)
									&& !(entityiterator instanceof FleshFangsEntity) && !(entityiterator instanceof HivemindTentaclesEntity) && !(new Object() {
										public boolean checkGamemode(Entity _ent) {
											if (_ent instanceof ServerPlayer _serverPlayer) {
												return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
											} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
												return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
														&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
											}
											return false;
										}
									}.checkGamemode(entityiterator)) && !(new Object() {
										public boolean checkGamemode(Entity _ent) {
											if (_ent instanceof ServerPlayer _serverPlayer) {
												return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
											} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
												return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
														&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
											}
											return false;
										}
									}.checkGamemode(entityiterator))) {
								entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * (double) DeepVoidConfigConfiguration.HIVEMINDPULLINTENSITY.get()), (entityiterator.getDeltaMovement().y()),
										((entity.getZ() - entityiterator.getZ()) * (double) DeepVoidConfigConfiguration.HIVEMINDPULLINTENSITY.get())));
							}
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !(entityiterator instanceof SawThrowerEntity) && !(entityiterator instanceof BoneSawEntity) && !(entityiterator instanceof SkullSmasherEntity)
								&& !(entityiterator instanceof FleshFangsEntity) && !(entityiterator instanceof HivemindTentaclesEntity) && !(new Object() {
									public boolean checkGamemode(Entity _ent) {
										if (_ent instanceof ServerPlayer _serverPlayer) {
											return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
										} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
											return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
													&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
										}
										return false;
									}
								}.checkGamemode(entityiterator)) && !(new Object() {
									public boolean checkGamemode(Entity _ent) {
										if (_ent instanceof ServerPlayer _serverPlayer) {
											return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
										} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
											return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
													&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
										}
										return false;
									}
								}.checkGamemode(entityiterator))) {
							if ((entity instanceof MisanthropicHivemindEntity _datEntL61 && _datEntL61.getEntityData().get(MisanthropicHivemindEntity.DATA_digesting)) == false) {
								if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
									_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_digesting, true);
								if (entity instanceof MisanthropicHivemindEntity) {
									((MisanthropicHivemindEntity) entity).setAnimation("animation.hivemind_digest");
								}
							}
							{
								Entity _ent = entityiterator;
								_ent.teleportTo((entity.getX()), (entity.getY() - 1), (entity.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entity.getX()), (entity.getY() - 1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
							}
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:digested"))), entity),
									(float) (double) DeepVoidConfigConfiguration.HIVEMINDDAMAGEDIGEST.get());
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 99, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2, 99, false, false));
							if (!(entityiterator instanceof LivingEntity _livEnt73 && _livEnt73.hasEffect(TheDeepVoidModMobEffects.BROKEN_ARMOR.get()))) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 100, 0, false, false));
							}
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (double) DeepVoidConfigConfiguration.HIVEMINDHEALDIGEST.get()));
							if (Math.random() < 0.25) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")),
												SoundSource.HOSTILE, (float) 0.2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")),
												SoundSource.HOSTILE, (float) 0.2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) > 0) {
				if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_sucking, (int) ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_sucking) : 0) - 1));
			}
		}
	}
}
