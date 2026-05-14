package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.MadCultistEntity;
import net.mcreator.thedeepvoid.entity.KunaiEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class MadCultistOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof MadCultistEntity _datEntL2 && _datEntL2.getEntityData().get(MadCultistEntity.DATA_aggressive)) == false
				&& (entity instanceof MadCultistEntity _datEntL3 && _datEntL3.getEntityData().get(MadCultistEntity.DATA_patrol)) == false) {
			if (entity instanceof MadCultistEntity _datEntSetL)
				_datEntSetL.getEntityData().set(MadCultistEntity.DATA_aggressive, true);
			if (entity instanceof MadCultistEntity) {
				((MadCultistEntity) entity).setAnimation("empty");
			}
			if (entity instanceof MadCultistEntity) {
				((MadCultistEntity) entity).setAnimation("animation.madCultist_notice");
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof MadCultistEntity _datEntL11 && _datEntL11.getEntityData().get(MadCultistEntity.DATA_attacking)) == false
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof MadCultistEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MadCultistEntity.DATA_attackChance, (int) ((entity instanceof MadCultistEntity _datEntI ? _datEntI.getEntityData().get(MadCultistEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof MadCultistEntity _datEntI ? _datEntI.getEntityData().get(MadCultistEntity.DATA_attackChance) : 0) >= 40) {
			if (entity instanceof MadCultistEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MadCultistEntity.DATA_attackChance, 0);
			rnd = Mth.nextInt(RandomSource.create(), 1, 4);
			if (rnd == 1) {
				if (entity instanceof MadCultistEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, true);
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("empty");
				}
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("animation.madCultist_slash");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
				TheDeepVoidMod.queueServerWork(12, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")), SoundSource.HOSTILE, 1, (float) 1.4);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:claws_slash")), SoundSource.HOSTILE, 1, (float) 1.4, false);
						}
					}
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								if ((entityiterator instanceof LivingEntity _entUseItem31 ? _entUseItem31.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
									if (entityiterator instanceof Player _player)
										_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem33 ? _entUseItem33.getUseItem() : ItemStack.EMPTY).getItem(), 60);
									{
										ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem35 ? _entUseItem35.getUseItem() : ItemStack.EMPTY);
										if (_ist.hurt(1, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.stopUsingItem();
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
													SoundSource.PLAYERS, (float) 0.4, 1);
										} else {
											_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS,
													(float) 0.4, 1, false);
										}
									}
									if (entity instanceof MadCultistEntity _datEntSetI)
										_datEntSetI.getEntityData().set(MadCultistEntity.DATA_attackChance, 60);
								} else {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 8);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 100, 0));
								}
							}
						}
					}
				});
				TheDeepVoidMod.queueServerWork(20, () -> {
					if (entity instanceof MadCultistEntity _datEntSetL)
						_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, false);
				});
			} else if (rnd == 2) {
				if (entity instanceof MadCultistEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, true);
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("empty");
				}
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("animation.madCultist_stab");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
				TheDeepVoidMod.queueServerWork(15, () -> {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 0.1, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.7);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.throw")), SoundSource.HOSTILE, 1, (float) 0.7, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(17, () -> {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								if ((entityiterator instanceof LivingEntity _entUseItem67 ? _entUseItem67.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
									if (entityiterator instanceof Player _player)
										_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem69 ? _entUseItem69.getUseItem() : ItemStack.EMPTY).getItem(), 60);
									{
										ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem71 ? _entUseItem71.getUseItem() : ItemStack.EMPTY);
										if (_ist.hurt(1, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.stopUsingItem();
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
													SoundSource.PLAYERS, (float) 0.4, 1);
										} else {
											_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS,
													(float) 0.4, 1, false);
										}
									}
									if (entity instanceof MadCultistEntity _datEntSetI)
										_datEntSetI.getEntityData().set(MadCultistEntity.DATA_attackChance, 60);
								} else {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 8);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 140, 0));
								}
							}
						}
					}
				});
				TheDeepVoidMod.queueServerWork(30, () -> {
					if (entity instanceof MadCultistEntity _datEntSetL)
						_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, false);
				});
			} else if (rnd == 3) {
				if (entity instanceof MadCultistEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, true);
				if (entity instanceof MadCultistEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MadCultistEntity.DATA_blocking, true);
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("empty");
				}
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("animation.madCultist_block");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
				TheDeepVoidMod.queueServerWork(30, () -> {
					if (entity instanceof MadCultistEntity _datEntSetL)
						_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, false);
					if (entity instanceof MadCultistEntity _datEntSetL)
						_datEntSetL.getEntityData().set(MadCultistEntity.DATA_blocking, false);
				});
			} else if (rnd == 4) {
				if (entity instanceof MadCultistEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, true);
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("empty");
				}
				if (entity instanceof MadCultistEntity) {
					((MadCultistEntity) entity).setAnimation("animation.madCultist_shoot");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
				TheDeepVoidMod.queueServerWork(22, () -> {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.6),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
					}
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KunaiEntity(TheDeepVoidModEntities.KUNAI.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 5, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.5, 2);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 1, (float) 1.8);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.HOSTILE, 1, (float) 1.8, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(30, () -> {
					if (entity instanceof MadCultistEntity _datEntSetL)
						_datEntSetL.getEntityData().set(MadCultistEntity.DATA_attacking, false);
				});
			}
		}
		if ((entity instanceof MadCultistEntity _datEntL116 && _datEntL116.getEntityData().get(MadCultistEntity.DATA_aggressive)) == false) {
			if (Math.random() < 0.002) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:quiet_slow_whisper")), SoundSource.HOSTILE, (float) 0.4,
								(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:quiet_slow_whisper")), SoundSource.HOSTILE, (float) 0.4,
								(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
					}
				}
			}
		}
	}
}
