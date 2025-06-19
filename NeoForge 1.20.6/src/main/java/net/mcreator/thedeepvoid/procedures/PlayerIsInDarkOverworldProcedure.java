package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

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
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerIsInDarkOverworldProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.STALKED.get() == true) {
			if ((entity.level().dimension()) == Level.OVERWORLD && !(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)) && !(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
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
						if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) < 2 && y >= 0
								&& (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING)) == false) {
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
	}
}
