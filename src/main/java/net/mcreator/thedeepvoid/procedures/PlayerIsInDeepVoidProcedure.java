package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerIsInDeepVoidProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			if (DeepVoidConfigConfiguration.PLAYERHALLUCINATES.get() == true) {
				if (entity.getY() <= 1 && (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.HALLUCINATE.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.HALLUCINATE.get()).getDuration() : 0) <= 8) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.HALLUCINATE.get(), 140, 0, false, false));
				}
			}
			if (y > 0) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).NightmareCount >= 10) {
					{
						double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).NightmareCount - 10;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.NightmareCount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (y <= 20) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).cave_tremble >= 10000) {
					{
						double _setval = 0;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cave_tremble = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (Math.random() < 0.4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.TREMBLE.get(), 200, 0, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:deep_rumble")), SoundSource.AMBIENT, 15, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:deep_rumble")), SoundSource.AMBIENT, 15, 1, false);
							}
						}
					}
				} else {
					{
						double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).cave_tremble + 1;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cave_tremble = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if (((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) == false) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerSpawn == true) {
				{
					boolean _setval = false;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StalkerSpawn = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:forgotten_valley")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:ashen_crags"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:mourning_graveyard")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:drifting_monoliths")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:staring_hills"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:filled_graveyard")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:grim_canopy"))) && y >= 40) {
			if (DeepVoidConfigConfiguration.SPAWNFALLINGCORPSE.get() == true) {
				if ((entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(TheDeepVoidModMobEffects.LURKER_HEAD_NEAR.get())) == false) {
					if (Math.random() < 0.005) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.FALLING_CORPSE.get().spawn(_level,
									BlockPos.containing(entity.getX() + Mth.nextDouble(RandomSource.create(), -20, 20), entity.getY() + 25, entity.getZ() + Mth.nextDouble(RandomSource.create(), -20, 20)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			}
		}
		if (TheDeepVoidModVariables.MapVariables.get(world).StalkerDespawned == true) {
			TheDeepVoidModVariables.MapVariables.get(world).StalkerDespawned = false;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
			{
				boolean _setval = false;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.StalkerSpawn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = false;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.StalkerCountFinish = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.StalkerCount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount == Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100)
				&& world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0 && y > 0 && (entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get())) == false) {
			{
				double _setval = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100) + 1;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.StalkerCount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
		}
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount == Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100)
				&& world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0 && y > 0 && (entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get())) == false) {
			{
				double _setval = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100) + 1;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.StalkerCount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
		}
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount >= Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 92) / 100)
				&& (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount < (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PARANOIA.get(), 5, 0, false, false));
		}
	}
}
