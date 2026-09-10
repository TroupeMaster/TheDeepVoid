package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.WardenOfThePitEntity;
import net.mcreator.thedeepvoid.entity.PrisonGuardEntity;
import net.mcreator.thedeepvoid.entity.GrabbingHandsEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class PrisonGuardOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:the_pit"))) {
				if (!(!world.getEntitiesOfClass(GrabbingHandsEntity.class, AABB.ofSize(new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())), 1, 1, 1), e -> true).isEmpty())) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.GRABBING_HANDS.get().spawn(_level, BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(),
								(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(), (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				TheDeepVoidMod.queueServerWork(54, () -> {
					if (!(!world.getEntitiesOfClass(WardenOfThePitEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entityinstance = TheDeepVoidModEntities.WARDEN_OF_THE_PIT.get().create(_serverLevel, null, null, new BlockPos(55, 5, 41), MobSpawnType.MOB_SUMMONED, false, false);
							if (entityinstance != null) {
								entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
								if (entityinstance instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
								_serverLevel.addFreshEntity(entityinstance);
							}
						}
					}
				});
			}
			if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_whistle) : 0) <= 0) {
				if (entity instanceof PrisonGuardEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_whistle, 3600);
				if (entity instanceof PrisonGuardEntity) {
					((PrisonGuardEntity) entity).setAnimation("empty");
				}
				if (entity instanceof PrisonGuardEntity) {
					((PrisonGuardEntity) entity).setAnimation("animation.prisonGuard_whistle");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 99, false, false));
				TheDeepVoidMod.queueServerWork(24, () -> {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_whistle")), SoundSource.HOSTILE, 4,
										(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_whistle")), SoundSource.HOSTILE, 4,
										(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
							}
						}
						if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:the_pit")))) {
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(42 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof PrisonGuardEntity && !(entityiterator == entity)) {
										if (entityiterator instanceof PrisonGuardEntity _datEntSetI)
											_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_whistle, 3600);
										if (entityiterator instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							}
						}
					}
				});
			} else {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)
						&& (entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_attackChance) : 0) <= 0) {
					if (entity instanceof PrisonGuardEntity _datEntSetI)
						_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_attackChance, 50);
					if (entity instanceof PrisonGuardEntity) {
						((PrisonGuardEntity) entity).setAnimation("animation.prisonGuard_lunge");
					}
					TheDeepVoidMod.queueServerWork(10, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
									if (!((entityiterator instanceof LivingEntity _entUseItem58 ? _entUseItem58.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 8);
									} else {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
														SoundSource.PLAYERS, 1, 1);
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1,
														1, false);
											}
										}
										if (entityiterator instanceof Player _player)
											_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem66 ? _entUseItem66.getUseItem() : ItemStack.EMPTY).getItem(), 5);
									}
								}
							}
						}
					});
				}
				if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_push) : 0) <= 0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
						if (entity instanceof PrisonGuardEntity _datEntSetI)
							_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_push, 240);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 99, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 99, false, false));
						if (entity instanceof PrisonGuardEntity) {
							((PrisonGuardEntity) entity).setAnimation("animation.prisonGuard_push");
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_attack")), SoundSource.HOSTILE, 1,
										(float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_attack")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
							}
						}
						TheDeepVoidMod.queueServerWork(2, () -> {
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof LivingEntity && !(entityiterator instanceof PrisonGuardEntity) && !(entityiterator == entity)) {
										if (!((entityiterator instanceof LivingEntity _entUseItem88 ? _entUseItem88.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 4);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
											entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entityiterator.getYRot() + 180)) * (-1)), 0.1, (Math.cos(Math.toRadians(entityiterator.getYRot())) * (-1))));
										} else {
											if ((entityiterator instanceof Player _plrCldRem97
													? _plrCldRem97.getCooldowns().getCooldownPercent((entityiterator instanceof LivingEntity _entUseItem96 ? _entUseItem96.getUseItem() : ItemStack.EMPTY).getItem(), 0f) * 100
													: 0) == 0) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
																SoundSource.PLAYERS, 1, 1);
													} else {
														_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
																SoundSource.PLAYERS, 1, 1, false);
													}
												}
												if (entityiterator instanceof Player _player)
													_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem102 ? _entUseItem102.getUseItem() : ItemStack.EMPTY).getItem(), 5);
											}
										}
									}
								}
							}
						});
					}
				} else if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_jump) : 0) <= 0
						&& (entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_push) : 0) > 0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
						if (entity instanceof PrisonGuardEntity _datEntSetI)
							_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_jump, 300);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 99, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 99, false, false));
						if (entity instanceof PrisonGuardEntity) {
							((PrisonGuardEntity) entity).setAnimation("animation.prisonGuard_dodge");
						}
						TheDeepVoidMod.queueServerWork(7, () -> {
							entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-1.4)), 0.25, (Math.cos(Math.toRadians(entity.getYRot())) * (-1.4))));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.5);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.5, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_dodge")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_dodge")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
								}
							}
						});
					}
				} else if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_roll) : 0) <= 0
						&& (entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_push) : 0) > 0
						&& (entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_jump) : 0) > 0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
						if (entity instanceof PrisonGuardEntity _datEntSetI)
							_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_roll, 200);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 99, false, false));
						if (entity instanceof PrisonGuardEntity) {
							((PrisonGuardEntity) entity).setAnimation("animation.prisonGuard_roll");
						}
						TheDeepVoidMod.queueServerWork(5, () -> {
							entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), 0.07, (Math.cos(Math.toRadians(entity.getYRot())) * 1.5)));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.8);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.8, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_dodge")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_dodge")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
								}
							}
						});
					}
				}
				if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_shield) : 0) <= 0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7, 7, 7), e -> true).isEmpty()) {
					if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7, 7, 7), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						if (!(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
								}
								return false;
							}
						}.checkGamemode((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null))) && !(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
								}
								return false;
							}
						}.checkGamemode((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))) {
							if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entUseItem153 ? _entUseItem153.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
								if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _plrCldRem158
										? _plrCldRem158.getCooldowns()
												.getCooldownPercent(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entUseItem157 ? _entUseItem157.getUseItem() : ItemStack.EMPTY).getItem(), 0f) * 100
										: 0) == 0) {
									if (entity instanceof PrisonGuardEntity _datEntSetI)
										_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_shield, 400);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 99, false, false));
									if (entity instanceof PrisonGuardEntity) {
										((PrisonGuardEntity) entity).setAnimation("animation.prisonGuard_attack");
									}
									if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player)
										_player.getCooldowns().addCooldown(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entUseItem165 ? _entUseItem165.getUseItem() : ItemStack.EMPTY).getItem(), 180);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null,
													BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(), (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(),
															(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()),
													ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, (float) 0.8);
										} else {
											_level.playLocalSound(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
													((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, (float) 0.8,
													false);
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_attack")), SoundSource.HOSTILE, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:prison_guard_attack")), SoundSource.HOSTILE, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_push) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_push, (int) ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_push) : 0) - 1));
		}
		if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_jump) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_jump, (int) ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_jump) : 0) - 1));
		}
		if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_roll) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_roll, (int) ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_roll) : 0) - 1));
		}
		if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_shield) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_shield, (int) ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_shield) : 0) - 1));
		}
		if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_attackChance) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_attackChance, (int) ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_attackChance) : 0) - 1));
		}
		if ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_whistle) : 0) > 0) {
			if (entity instanceof PrisonGuardEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonGuardEntity.DATA_whistle, (int) ((entity instanceof PrisonGuardEntity _datEntI ? _datEntI.getEntityData().get(PrisonGuardEntity.DATA_whistle) : 0) - 1));
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:the_pit")) && !(entity instanceof LivingEntity _livEnt197 && _livEnt197.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) Double.POSITIVE_INFINITY, 99, false, false));
		}
	}
}
