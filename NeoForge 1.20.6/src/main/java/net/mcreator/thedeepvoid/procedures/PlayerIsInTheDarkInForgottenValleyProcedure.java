package net.mcreator.thedeepvoid.procedures;

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
import net.minecraft.core.registries.BuiltInRegistries;
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
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount >= (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() && entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerSpawn == false
						&& entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCountFinish == false) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.StalkerCountFinish = true;
						_vars.syncPlayerVariables(entity);
					}
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.StalkerCount = 0;
						_vars.syncPlayerVariables(entity);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					TheDeepVoidMod.queueServerWork(80, () -> {
						if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) == 0) {
							if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerSpawn == false) {
								{
									TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
									_vars.StalkerSpawn = true;
									_vars.syncPlayerVariables(entity);
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
								TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
								_vars.StalkerCountFinish = false;
								_vars.syncPlayerVariables(entity);
							}
							{
								TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
								_vars.StalkerSpawn = false;
								_vars.syncPlayerVariables(entity);
							}
						}
					});
				} else {
					if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCountFinish == false) {
						if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) == 0 && y >= 0
								&& (entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING)) == false) {
							{
								TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
								_vars.StalkerCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount + 1;
								_vars.syncPlayerVariables(entity);
							}
						} else {
							if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount > 0) {
								{
									TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
									_vars.StalkerCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount - 4;
									_vars.syncPlayerVariables(entity);
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
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerStalkCount == 560) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.StalkerStalkCount = 0;
						_vars.syncPlayerVariables(entity);
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
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.StalkerStalkCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerStalkCount + 1;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
