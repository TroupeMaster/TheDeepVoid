package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class PlayerIsInTheDarkInForgottenValleyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.STALKERSPAWNS.get() == true) {
			if ((world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:forgotten_valley")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:ashen_crags"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:mourning_graveyard")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:windswept_hollow"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:drifting_monoliths")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:watching_undergrowth"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:filled_graveyard")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:grim_canopy"))) && (new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
							}
							return false;
						}
					}.checkGamemode(entity) || new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
							}
							return false;
						}
					}.checkGamemode(entity))) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount >= (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get()
						&& (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerSpawn == false
						&& (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCountFinish == false) {
					{
						boolean _setval = true;
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
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					TheDeepVoidMod.queueServerWork(80, () -> {
						if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) == 0) {
							if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerSpawn == false) {
								{
									boolean _setval = true;
									entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StalkerSpawn = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.STALKER.get().spawn(_level,
											BlockPos.containing(entity.getX() + Mth.nextDouble(RandomSource.create(), -40, 40) + 5, entity.getY(), entity.getZ() + Mth.nextDouble(RandomSource.create(), -40, 40) + 5), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						} else {
							{
								boolean _setval = false;
								entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StalkerCountFinish = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = false;
								entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StalkerSpawn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					});
				} else {
					if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCountFinish == false) {
						if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) == 0 && y >= 0
								&& (entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get())) == false) {
							{
								double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount + 1;
								entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StalkerCount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount > 0) {
								{
									double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount - 4;
									entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StalkerCount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			}
		}
		if (DeepVoidConfigConfiguration.STALKINGSTALKERSPAWNS.get() == true) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:forgotten_valley")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:ashen_crags"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:mourning_graveyard")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:windswept_hollow"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:drifting_monoliths")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:watching_undergrowth"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:filled_graveyard")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:grim_canopy"))) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerStalkCount == 560) {
					{
						double _setval = 0;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StalkerStalkCount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (!world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 450, 450, 450), e -> true).isEmpty() == false
							&& !world.getEntitiesOfClass(StalkingStalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty() == false && y >= 40) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.STALKING_STALKER.get().spawn(_level,
									BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -100, 100), entity.getY(), z + Mth.nextDouble(RandomSource.create(), -100, 100)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				} else {
					{
						double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerStalkCount + 1;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StalkerStalkCount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
