package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class HallucinateEyesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.25) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 7) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getX() + Mth.nextDouble(RandomSource.create(), -10, 10);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getY() + Mth.nextDouble(RandomSource.create(), -8, 8);
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()), entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
							entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, 1, 0, 0, 0, 0);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()), (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
								entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY, (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 1, 0, 0, 0, 0);
				}
				if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
											entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				} else if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
											entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 1) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(6)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getX() + Mth.nextDouble(RandomSource.create(), -10, 10);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(6)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(6)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getY() + Mth.nextDouble(RandomSource.create(), -8, 8);
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()), entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
							entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, 1, 0, 0, 0, 0);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()), (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
								entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY, (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 1, 0, 0, 0, 0);
				}
				if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
											entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				} else if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
											entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 1) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getX() + Mth.nextDouble(RandomSource.create(), -5, 5);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getZ() + Mth.nextDouble(RandomSource.create(), -5, 5);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.hallucinateY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
							.getY() + Mth.nextDouble(RandomSource.create(), -6, 6);
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()), entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
							entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, 1, 0, 0, 0, 0);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()), (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
								entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY, (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 1, 0, 0, 0, 0);
				}
				if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
											entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				} else if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
											entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateY,
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
			}
		}
		if (DeepVoidConfigConfiguration.DARKNESS.get() == true) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 1) {
				if (!(entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING))) {
					if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateHurt >= 40) {
						{
							TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
							_vars.hallucinateHurt = 0;
							_vars.syncPlayerVariables(entity);
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 1) {
							if (entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 4)
												* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0) + 1)
												+ entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).darknessDamageBuildUp / 2));
							} else {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 4) + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).darknessDamageBuildUp / 2));
							}
						} else {
							if (entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0) + 2)
												+ entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).darknessDamageBuildUp / 2));
							} else {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).darknessDamageBuildUp / 2));
							}
						}
						{
							TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
							_vars.darknessDamageBuildUp = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).darknessDamageBuildUp + 1;
							_vars.syncPlayerVariables(entity);
						}
						if (Math.random() < 0.8) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
								}
							}
						} else if (Math.random() < 0.8) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
								}
							}
						}
					} else {
						{
							TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
							_vars.hallucinateHurt = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateHurt + 1;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 1) {
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).darknessDamageBuildUp > 0) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.darknessDamageBuildUp = 0;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
