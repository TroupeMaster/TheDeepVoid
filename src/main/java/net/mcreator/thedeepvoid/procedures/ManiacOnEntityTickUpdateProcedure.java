package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.ShotgunPelletEntity;
import net.mcreator.thedeepvoid.entity.ManiacEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ManiacOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof ManiacEntity _datEntL2 && _datEntL2.getEntityData().get(ManiacEntity.DATA_attacking)) == false) {
			if (entity instanceof ManiacEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ManiacEntity.DATA_attackChance, (int) ((entity instanceof ManiacEntity _datEntI ? _datEntI.getEntityData().get(ManiacEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof ManiacEntity _datEntI ? _datEntI.getEntityData().get(ManiacEntity.DATA_attackChance) : 0) >= 80) {
			if (entity instanceof ManiacEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ManiacEntity.DATA_attackChance, 0);
			if (entity instanceof ManiacEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ManiacEntity.DATA_attacking, true);
			if ((entity instanceof ManiacEntity _datEntL8 && _datEntL8.getEntityData().get(ManiacEntity.DATA_empty)) == true) {
				if (entity instanceof ManiacEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ManiacEntity.DATA_empty, false);
				if (entity instanceof ManiacEntity) {
					((ManiacEntity) entity).setAnimation("empty");
				}
				if (entity instanceof ManiacEntity) {
					((ManiacEntity) entity).setAnimation("animation.maniac_reload");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 99, false, false));
				TheDeepVoidMod.queueServerWork(7, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_release")), SoundSource.HOSTILE, (float) 0.6,
									1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_release")), SoundSource.HOSTILE, (float) 0.6, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(12, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_open")), SoundSource.HOSTILE, (float) 0.6,
									1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_open")), SoundSource.HOSTILE, (float) 0.6, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.SHOTGUN_SHELL.get()), entity.getX() + entity.getLookAngle().x * 0.6, entity.getY() + entity.getLookAngle().y + 1.5 * 0.6,
								entity.getZ() + entity.getLookAngle().z * 0.6, 2, 0.8, 1, 0.8, 0.1);
				});
				TheDeepVoidMod.queueServerWork(27, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_insert")), SoundSource.HOSTILE, (float) 0.6,
									1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_insert")), SoundSource.HOSTILE, (float) 0.6, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(32, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_insert")), SoundSource.HOSTILE, (float) 0.6,
									1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_insert")), SoundSource.HOSTILE, (float) 0.6, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(40, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_open")), SoundSource.HOSTILE, (float) 0.6,
									(float) 0.98);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_open")), SoundSource.HOSTILE, (float) 0.6, (float) 0.98,
									false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(50, () -> {
					if (entity instanceof ManiacEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ManiacEntity.DATA_attacking, false);
				});
			} else {
				if (entity instanceof ManiacEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ManiacEntity.DATA_empty, true);
				if (entity instanceof ManiacEntity) {
					((ManiacEntity) entity).setAnimation("empty");
				}
				if (entity instanceof ManiacEntity) {
					((ManiacEntity) entity).setAnimation("animation.maniac_shoot");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 35, 99, false, false));
				TheDeepVoidMod.queueServerWork(14, () -> {
					for (int index0 = 0; index0 < 2; index0++) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_trigger")), SoundSource.HOSTILE, 3,
										(float) Mth.nextDouble(RandomSource.create(), 0.97, 1.03));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_trigger")), SoundSource.HOSTILE, 3,
										(float) Mth.nextDouble(RandomSource.create(), 0.97, 1.03), false);
							}
						}
					}
				});
				TheDeepVoidMod.queueServerWork(15, () -> {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
						if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
							entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.6),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_shoot")), SoundSource.HOSTILE, 4,
										(float) Mth.nextDouble(RandomSource.create(), 0.99, 1.01));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:double_barrel_shoot")), SoundSource.HOSTILE, 4,
										(float) Mth.nextDouble(RandomSource.create(), 0.99, 1.01), false);
							}
						}
						for (int index1 = 0; index1 < 11; index1++) {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new ShotgunPelletEntity(TheDeepVoidModEntities.SHOTGUN_PELLET.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, (float) 3.2, (int) 0.1);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 18);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new ShotgunPelletEntity(TheDeepVoidModEntities.SHOTGUN_PELLET.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 1, (int) 0.1);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 4);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-0.25)), (Math.sin(Math.toRadians(0 - entity.getXRot())) * (-0.25)), (Math.cos(Math.toRadians(entity.getYRot())) * (-0.25))));
					}
				});
				TheDeepVoidMod.queueServerWork(35, () -> {
					if (entity instanceof ManiacEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ManiacEntity.DATA_attacking, false);
				});
			}
		}
	}
}
