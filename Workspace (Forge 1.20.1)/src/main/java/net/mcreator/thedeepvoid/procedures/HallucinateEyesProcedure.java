package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HallucinateEyesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.25) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 7) {
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextDouble(RandomSource.create(), -10, 10);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextDouble(RandomSource.create(), -10, 10);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextDouble(RandomSource.create(), -8, 8);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ), 1, 0, 0, 0, 0);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 1, 0, 0, 0, 0);
				}
				if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				} else if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 1) {
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(6)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextDouble(RandomSource.create(), -10, 10);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(6)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextDouble(RandomSource.create(), -10, 10);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(6)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextDouble(RandomSource.create(), -8, 8);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ), 1, 0, 0, 0, 0);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 1, 0, 0, 0, 0);
				}
				if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				} else if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 1) {
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextDouble(RandomSource.create(), -5, 5);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextDouble(RandomSource.create(), -5, 5);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextDouble(RandomSource.create(), -6, 6);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinateY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
							((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ), 1, 0, 0, 0, 0);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.EYE.get()),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 1, 0, 0, 0, 0);
				}
				if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				} else if (Math.random() < 0.008) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateX),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateY),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
						}
					}
				}
			}
		}
		if (DeepVoidConfigConfiguration.DARKNESS.get() == true) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 1) {
				if (!(entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get()))) {
					if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateHurt >= 40) {
						{
							double _setval = 0;
							entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hallucinateHurt = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 1) {
							if (entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 4)
												* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0) + 1)
												+ (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).darknessDamageBuildUp / 2));
							} else {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 4)
												+ (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).darknessDamageBuildUp / 2));
							}
						} else {
							if (entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0) + 2)
												+ (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).darknessDamageBuildUp / 2));
							} else {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:monsters_in_the_dark")))),
										(float) (2 + (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).darknessDamageBuildUp / 2));
							}
						}
						{
							double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).darknessDamageBuildUp + 1;
							entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.darknessDamageBuildUp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (Math.random() < 0.8) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
								}
							}
						} else if (Math.random() < 0.8) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1));
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:slow_whispers_2")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.1), false);
								}
							}
						}
					} else {
						{
							double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinateHurt + 1;
							entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hallucinateHurt = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			} else if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 1) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).darknessDamageBuildUp > 0) {
					{
						double _setval = 0;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.darknessDamageBuildUp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinating == true) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinate >= 240) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.HALLUCINATION.get().spawn(_level,
							BlockPos.containing(entity.getX() + Mth.nextDouble(RandomSource.create(), -16, 16), entity.getY(), entity.getZ() + Mth.nextDouble(RandomSource.create(), -16, 16)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hallucinate + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hallucinate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).NightmareCount >= 4000 && (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)) == false && (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)) == false) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NightmareCount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:nightmare_appear")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:nightmare_appear")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.NIGHTMARE.get().spawn(_level, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -20, 20), y, z + Mth.nextDouble(RandomSource.create(), -20, 20)),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			}
			if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
					} else {
						_level.playLocalSound(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
					}
				}
				TheDeepVoidMod.queueServerWork(20, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(40, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(30, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(40, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
			} else if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:lurker_ambient")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
					} else {
						_level.playLocalSound(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:lurker_ambient")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
					}
				}
			} else if (Math.random() < 0.0005) {
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.getY(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.7, 1));
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.7, 1), false);
						}
					}
				}
			} else if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
					} else {
						_level.playLocalSound(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
					}
				}
				TheDeepVoidMod.queueServerWork(5, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(10, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(15, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(20, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
			} else if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(
								null, BlockPos
										.containing(
												entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
																ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX(),
												entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3), entity.level().clip(new ClipContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(
								(entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
												entity))
										.getBlockPos().getX()),
								(entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3)),
								(entity.level().clip(
										new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getZ()),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(8, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(
											entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
															ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3), entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(
									(entity.level()
											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entity))
											.getBlockPos().getX()),
									(entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3)), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(16, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(
											entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
															ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3), entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(
									(entity.level()
											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entity))
											.getBlockPos().getX()),
									(entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3)), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				});
			} else if (Math.random() < 0.0005) {
				{
					double _setval = entity.getX() + Mth.nextInt(RandomSource.create(), -15, 15);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.soundHallX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.getY() + Mth.nextInt(RandomSource.create(), -2, 2);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.soundHallY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.getZ() + Mth.nextInt(RandomSource.create(), -15, 15);
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.soundHallZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null,
								BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallX,
										(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallY,
										(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallZ),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallX),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallY),
								((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallZ),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(25, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallX,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallY + 1,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallX),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallY + 1),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallZ),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(50, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallX + Mth.nextInt(RandomSource.create(), 0, 1),
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallY,
											(entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallZ + Mth.nextInt(RandomSource.create(), 0, 1)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallX + Mth.nextInt(RandomSource.create(), 0, 1)),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallY),
									((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).soundHallZ + Mth.nextInt(RandomSource.create(), 0, 1)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				});
			}
		}
	}
}
