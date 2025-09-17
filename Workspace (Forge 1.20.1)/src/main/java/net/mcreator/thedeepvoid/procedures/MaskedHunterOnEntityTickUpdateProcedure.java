package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.RotKnifeEntity;
import net.mcreator.thedeepvoid.entity.PoisonKnifeEntity;
import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.entity.BoneCageEntity;
import net.mcreator.thedeepvoid.entity.BoneCageClosedEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class MaskedHunterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.isInWaterOrBubble()) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).isInWaterOrBubble()) {
				entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.05),
						(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) * 0.05), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.05)));
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
		}
		if (DeepVoidConfigConfiguration.SPAWNBONECAGES.get() == true) {
			if (!(!world.getEntitiesOfClass(BoneCageEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())
					&& !(!world.getEntitiesOfClass(BoneCageClosedEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) && !entity.isInWaterOrBubble()) {
				if (entity.getPersistentData().getDouble("placeTrap") <= 0) {
					entity.getPersistentData().putDouble("placeTrap", 400);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.BONE_CAGE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					entity.getPersistentData().putDouble("placeTrap", (entity.getPersistentData().getDouble("placeTrap") - 1));
				}
			}
		}
		if (entity.getPersistentData().getDouble("playSound") >= 800) {
			entity.getPersistentData().putDouble("playSound", 0);
			entity.getPersistentData().putDouble("randomChance", Math.random());
			if (entity.getPersistentData().getDouble("randomChance") < 0.1) {
				entity.getPersistentData().putDouble("randomSound", (Mth.nextInt(RandomSource.create(), 1, 2)));
				if (entity.getPersistentData().getDouble("randomSound") == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream1")), SoundSource.HOSTILE, 16,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream1")), SoundSource.HOSTILE, 16, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
					entity.getPersistentData().putDouble("randomChance", Math.random());
					if (entity.getPersistentData().getDouble("randomChance") < 0.25 && world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:hunter_forest_biome")))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT, 16, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT, 16, 1, false);
							}
						}
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream2")), SoundSource.HOSTILE, 16,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream2")), SoundSource.HOSTILE, 16, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
					entity.getPersistentData().putDouble("randomChance", Math.random());
					if (entity.getPersistentData().getDouble("randomChance") < 0.25 && world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:hunter_forest_biome")))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT, 16, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crows_fly")), SoundSource.AMBIENT, 16, 1, false);
							}
						}
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("playSound", (entity.getPersistentData().getDouble("playSound") + 1));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && !entity.isInWaterOrBubble()) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
				if (Math.random() < 0.02) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream1")), SoundSource.HOSTILE, 3,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream1")), SoundSource.HOSTILE, 3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
				if (Math.random() < 0.02) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream2")), SoundSource.HOSTILE, 3,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:masked_hunter_scream2")), SoundSource.HOSTILE, 3, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && !entity.isInWaterOrBubble()) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt65 && _livEnt65.hasEffect(TheDeepVoidModMobEffects.ROT.get()))
					&& !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt67 && _livEnt67.hasEffect(MobEffects.POISON))
					&& (!world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty() || !world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())) {
				if (entity.getPersistentData().getDouble("shoot") >= 200) {
					if (Math.random() < 0.02) {
						entity.getPersistentData().putDouble("shoot", 0);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9, 99, false, false));
						if (entity instanceof MaskedHunterEntity) {
							((MaskedHunterEntity) entity).setAnimation("animation.hunterTrue_shoot");
						}
						TheDeepVoidMod.queueServerWork(3, () -> {
							entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.4),
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
									}.getArrow(projectileLevel, entity, 2, 0);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.5, 1);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
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
									}.getArrow(projectileLevel, entity, 2, 0);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.5, 1);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 1, (float) 1.2);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 1, (float) 1.2, false);
								}
							}
						});
					}
				} else {
					entity.getPersistentData().putDouble("shoot", (entity.getPersistentData().getDouble("shoot") + 1));
				}
			}
			if (entity.getPersistentData().getDouble("spawnSpike") >= 240) {
				entity.getPersistentData().putDouble("spawnSpike", 0);
				if (Math.random() < 0.4) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.GIANT_BONE_SPIKE.get()
								.spawn(_level,
										BlockPos.containing(
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(6)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getX(),
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(),
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(6)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getZ()),
										MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.GIANT_BONE_SPIKE.get()
								.spawn(_level,
										BlockPos.containing(
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(6)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getX() + Mth.nextInt(RandomSource.create(), -1, 1),
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(),
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(6)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getZ()),
										MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.GIANT_BONE_SPIKE.get()
								.spawn(_level,
										BlockPos.containing(
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(6)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getX(),
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(),
												(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
														.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
																(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f)
																		.add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(6)),
																ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
														.getBlockPos().getZ() + Mth.nextInt(RandomSource.create(), -1, 1)),
										MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("spawnSpike", (entity.getPersistentData().getDouble("spawnSpike") + 1));
			}
		}
		if (entity instanceof LivingEntity _livEnt117 && _livEnt117.hasEffect(TheDeepVoidModMobEffects.ROT.get()) || entity instanceof LivingEntity _livEnt118 && _livEnt118.hasEffect(MobEffects.POISON)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheDeepVoidModMobEffects.ROT.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.POISON);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
			}
		}
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
	}
}
