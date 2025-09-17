package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
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
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.RotKnifeEntity;
import net.mcreator.thedeepvoid.entity.PoisonKnifeEntity;
import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ApostleOfCatastropheOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double playerDashX = 0;
		double playerDashZ = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			entity.getPersistentData().putDouble("deep_void:attackChance", (entity.getPersistentData().getDouble("deep_void:attackChance") + 1));
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 1.8) {
				entity.getPersistentData().putDouble("deep_void:attackChance", (entity.getPersistentData().getDouble("deep_void:attackChance") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 40) {
			if (entity instanceof ApostleOfCatastropheEntity) {
				((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_teleport");
			}
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), y, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 15, 99, false, false));
			TheDeepVoidMod.queueServerWork(15, () -> {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.7);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.7, false);
						}
					}
					if (Math.random() < 0.4) {
						{
							Entity _ent = entity;
							_ent.teleportTo(
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
											.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
													(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(4)),
													ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
											.getBlockPos().getX()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
											.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
													(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(4)),
													ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
											.getBlockPos().getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection
										.teleport(
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(4)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getX()),
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(4)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getZ()),
												_ent.getYRot(), _ent.getXRot());
						}
					} else {
						{
							Entity _ent = entity;
							_ent.teleportTo(
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
											.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
													(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-5))),
													ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
											.getBlockPos().getX()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
											.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
													(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-5))),
													ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
											.getBlockPos().getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection
										.teleport(
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-5))),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getX()),
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale((-5))),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getZ()),
												_ent.getYRot(), _ent.getXRot());
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2.4) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 2, (float) 0.8);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 2, (float) 0.8, false);
							}
						}
						entity.getPersistentData().putDouble("deep_void:playerDashX", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
						entity.getPersistentData().putDouble("deep_void:playerDashZ", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
						TheDeepVoidMod.queueServerWork(35, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 2, (float) 0.6);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 2, (float) 0.6, false);
								}
							}
							if (entity instanceof ApostleOfCatastropheEntity) {
								((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_melee");
							}
							entity.setDeltaMovement(new Vec3(((entity.getPersistentData().getDouble("deep_void:playerDashX") - entity.getX()) * 0.2), 0.05, ((entity.getPersistentData().getDouble("deep_void:playerDashZ") - entity.getZ()) * 0.2)));
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										y, (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player) {
										if ((entityiterator instanceof LivingEntity _entUseItem65 ? _entUseItem65.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.HOSTILE, 1, 1);
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.HOSTILE, 1, 1, false);
												}
											}
											{
												ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem71 ? _entUseItem71.getUseItem() : ItemStack.EMPTY);
												if (_ist.hurt(5, RandomSource.create(), null)) {
													_ist.shrink(1);
													_ist.setDamageValue(0);
												}
											}
											if (entityiterator instanceof Player _player)
												_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem73 ? _entUseItem73.getUseItem() : ItemStack.EMPTY).getItem(), 20);
										} else {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 6);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")), SoundSource.HOSTILE, 1, 1);
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")),
															SoundSource.HOSTILE, 1, 1, false);
												}
											}
										}
									}
								}
							}
						});
					}
				}
			});
			if (Math.random() < 0.1) {
				entity.getPersistentData().putDouble("deep_void:attackChance", 0);
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 120) {
			if (entity instanceof ApostleOfCatastropheEntity) {
				((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_shoot");
			}
			entity.getPersistentData().putBoolean("deep_void:shooting", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 15, 99, false, false));
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), y, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
			TheDeepVoidMod.queueServerWork(11, () -> {
				entity.getPersistentData().putBoolean("deep_void:shooting", false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8, false);
					}
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new RotKnifeEntity(TheDeepVoidModEntities.ROT_KNIFE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 4, 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.38), (entity.getZ()));
					_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.2), 0.02, (Math.cos(Math.toRadians(entity.getYRot())) * 0.2), (float) 1.4, 1);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new PoisonKnifeEntity(TheDeepVoidModEntities.POISON_KNIFE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 4, 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.38), (entity.getZ()));
					_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.8), 0.02, (Math.cos(Math.toRadians(entity.getYRot())) * 0.2), (float) 1.4, (float) 1.5);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new PoisonKnifeEntity(TheDeepVoidModEntities.POISON_KNIFE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 4, 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.38), (entity.getZ()));
					_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.2), 0.02, (Math.cos(Math.toRadians(entity.getYRot())) * 0.8), (float) 1.4, (float) 1.5);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			});
			if (Math.random() < 0.1) {
				entity.getPersistentData().putDouble("deep_void:attackChance", 0);
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 180) {
			if (entity instanceof ApostleOfCatastropheEntity) {
				((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_slash");
			}
			entity.getPersistentData().putBoolean("deep_void:slashing", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 15, 99, false, false));
			TheDeepVoidMod.queueServerWork(25, () -> {
				entity.getPersistentData().putBoolean("deep_void:slashing", false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")), SoundSource.HOSTILE, 3, (float) 0.7);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")), SoundSource.HOSTILE, 3, (float) 0.7, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")), SoundSource.HOSTILE, 3, (float) 0.7);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")), SoundSource.HOSTILE, 3, (float) 0.7, false);
					}
				}
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY() + 1),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (!entityiterator.isShiftKeyDown() || (world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 0.7, entityiterator.getZ()))).getBlock() == Blocks.AIR) {
								entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), 0.5, (Math.cos(Math.toRadians(entity.getYRot())) * 1.5)));
								if ((entityiterator instanceof LivingEntity _entUseItem152 ? _entUseItem152.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
									{
										ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem154 ? _entUseItem154.getUseItem() : ItemStack.EMPTY);
										if (_ist.hurt(28, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entityiterator instanceof Player _player)
										_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem156 ? _entUseItem156.getUseItem() : ItemStack.EMPTY).getItem(), 120);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
													SoundSource.PLAYERS, 1, (float) 0.8);
										} else {
											_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1,
													(float) 0.8, false);
										}
									}
								} else {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 14);
								}
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80, 0));
							}
						}
					}
				}
			});
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 280) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getYRot() + 180)) * 1.6), 0.6,
						(Math.cos(Math.toRadians((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getYRot())) * 1.6)));
			}
			if (entity instanceof ApostleOfCatastropheEntity) {
				((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_shoot");
			}
			entity.getPersistentData().putBoolean("deep_void:shooting", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 15, 99, false, false));
			TheDeepVoidMod.queueServerWork(11, () -> {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					entity.getPersistentData().putBoolean("deep_void:shooting", false);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8, false);
						}
					}
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new RotKnifeEntity(TheDeepVoidModEntities.ROT_KNIFE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 4, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			});
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 1.8) {
				TheDeepVoidMod.queueServerWork(14, () -> {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.NEUTRAL, 2, (float) 1.8);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.NEUTRAL, 2, (float) 1.8, false);
							}
						}
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new PoisonKnifeEntity(TheDeepVoidModEntities.POISON_KNIFE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 4, 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 3);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					}
				});
				TheDeepVoidMod.queueServerWork(15, () -> {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8, false);
							}
						}
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new PoisonKnifeEntity(TheDeepVoidModEntities.POISON_KNIFE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 4, 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 3);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					}
				});
				TheDeepVoidMod.queueServerWork(18, () -> {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8, false);
							}
						}
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new RotKnifeEntity(TheDeepVoidModEntities.ROT_KNIFE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 4, 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 1);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					}
				});
			}
			if (Math.random() < 0.1) {
				entity.getPersistentData().putDouble("deep_void:attackChance", 0);
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 340) {
			if (entity instanceof ApostleOfCatastropheEntity) {
				((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_spin");
			}
			entity.getPersistentData().putBoolean("deep_void:spinning", true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_hysterical_laugh")), SoundSource.HOSTILE, 4, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_hysterical_laugh")), SoundSource.HOSTILE, 4, 1, false);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 75, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 75, 1, false, false));
			if (Math.random() < 0.1) {
				entity.getPersistentData().putDouble("deep_void:attackChance", 0);
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 420) {
			if (entity instanceof ApostleOfCatastropheEntity) {
				((ApostleOfCatastropheEntity) entity).setAnimation("animation.apostle_noEscape");
			}
			entity.getPersistentData().putBoolean("deep_void:noEscape", true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 2, (float) 1.2);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 2, (float) 1.2, false);
				}
			}
			TheDeepVoidMod.queueServerWork(18, () -> {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				}
				entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.45), 0.055, (Math.cos(Math.toRadians(entity.getYRot())) * 1.45)));
			});
			TheDeepVoidMod.queueServerWork(20, () -> {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
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
								{
									boolean _setval = true;
									entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.noEscape = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
							}
						}
					}
				}
			});
			TheDeepVoidMod.queueServerWork(62, () -> {
				entity.getPersistentData().putBoolean("deep_void:noEscape", false);
			});
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") >= 520) {
			entity.getPersistentData().putDouble("deep_void:attackChance", 0);
		}
		if (entity.getPersistentData().getBoolean("deep_void:spinning") == true) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if ((entityiterator instanceof LivingEntity _entUseItem293 ? _entUseItem293.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
											SoundSource.HOSTILE, 1, (float) 1.2);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.HOSTILE, 1,
											(float) 1.2, false);
								}
							}
							{
								ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem299 ? _entUseItem299.getUseItem() : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
							if (entityiterator instanceof Player _player)
								_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem301 ? _entUseItem301.getUseItem() : ItemStack.EMPTY).getItem(), 100);
						} else {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 2);
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 1));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 5, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT.get(), 5, 0));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
											SoundSource.HOSTILE, 1, (float) 1.4);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.HOSTILE, 1,
											(float) 1.4, false);
								}
							}
						}
					}
				}
			}
			if (Math.random() < 0.1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8, false);
					}
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new RotKnifeEntity(TheDeepVoidModEntities.ROT_KNIFE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 4, 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 2), (entity.getZ()));
					_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * Mth.nextDouble(RandomSource.create(), -1, 1)), (-0.2), (Math.cos(Math.toRadians(entity.getYRot())) * Mth.nextDouble(RandomSource.create(), -1, 1)), 1, 5);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 2, (float) 1.8, false);
					}
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new PoisonKnifeEntity(TheDeepVoidModEntities.POISON_KNIFE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 4, 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 2), (entity.getZ()));
					_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * Mth.nextDouble(RandomSource.create(), -1, 1)), (-0.2), (Math.cos(Math.toRadians(entity.getYRot())) * Mth.nextDouble(RandomSource.create(), -1, 1)), 1, 5);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			TheDeepVoidMod.queueServerWork(75, () -> {
				entity.getPersistentData().putBoolean("deep_void:spinning", false);
			});
		}
		if (entity.getPersistentData().getBoolean("deep_void:spinning") == false) {
			if (entity.getPersistentData().getDouble("deep_void:laughChance") == 20) {
				entity.getPersistentData().putDouble("deep_void:laughChance", 0);
				if (Math.random() < 0.04) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 4,
									(float) Mth.nextDouble(RandomSource.create(), 0.7, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:apostle_laugh")), SoundSource.HOSTILE, 4,
									(float) Mth.nextDouble(RandomSource.create(), 0.7, 1.1), false);
						}
					}
					if (Math.random() < 0.2) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.combat_line1").getString())), false);
								}
							}
						}
					} else if (Math.random() < 0.15) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.combat_line2").getString())), false);
								}
							}
						}
					} else if (Math.random() < 0.2) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.combat_line3").getString())), false);
								}
							}
						}
					} else if (Math.random() < 0.15) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.combat_line4").getString())), false);
								}
							}
						}
					} else if (Math.random() < 0.15) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.combat_line5").getString())), false);
								}
							}
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("deep_void:laughChance", (entity.getPersistentData().getDouble("deep_void:laughChance") + 1));
			}
		}
		if (entity.getPersistentData().getBoolean("deep_void:noEscape") == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 3, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 99, false, false));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
					}
				}
			}
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())) {
			if (entity.getPersistentData().getBoolean("deep_void:fog") == true) {
				entity.getPersistentData().putBoolean("deep_void:fog", false);
			}
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.IDLING_APOSTLE.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("deep_void:forgeX"), entity.getPersistentData().getDouble("deep_void:forgeY"), entity.getPersistentData().getDouble("deep_void:forgeZ")), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("deep_void:forgeX"), entity.getPersistentData().getDouble("deep_void:forgeY"), entity.getPersistentData().getDouble("deep_void:forgeZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.6);
				} else {
					_level.playLocalSound((entity.getPersistentData().getDouble("deep_void:forgeX")), (entity.getPersistentData().getDouble("deep_void:forgeY")), (entity.getPersistentData().getDouble("deep_void:forgeZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.6, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:chainsaw");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:chainsaw");
			});
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
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
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
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
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
				{
					Entity _ent = entity;
					_ent.teleportTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), _ent.getYRot(), _ent.getXRot());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.6);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 2, (float) 0.6, false);
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
			if (!(entity instanceof LivingEntity _livEnt415 && _livEnt415.hasEffect(TheDeepVoidModMobEffects.CHAINSAW_MUSIC.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.CHAINSAW_MUSIC.get(), 2350, 0, false, false));
			}
		} else {
			if (entity instanceof LivingEntity _livEnt417 && _livEnt417.hasEffect(TheDeepVoidModMobEffects.CHAINSAW_MUSIC.get())) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TheDeepVoidModMobEffects.CHAINSAW_MUSIC.get());
			}
		}
	}
}
