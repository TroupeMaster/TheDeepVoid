package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerInGloomyDeathgroundsProcedure {
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
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gathering_grounds"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).gatheringAmbience >= 400) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gatheringAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (Math.random() < 0.4) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:soul_passing_by ambient @s ~ ~ ~ 10 1 0.5");
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).gatheringAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gatheringAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).mistedRemnantAmbience >= 2000) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mistedRemnantAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (Math.random() < 0.1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + 10, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x + 10), y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					TheDeepVoidMod.queueServerWork(20, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + 8, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x + 8), y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
					TheDeepVoidMod.queueServerWork(40, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + 6, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x + 6), y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
					TheDeepVoidMod.queueServerWork(60, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + 4, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x + 4), y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
				} else if (Math.random() < 0.1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z + 14), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, (z + 14), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					TheDeepVoidMod.queueServerWork(8, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z + 12), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z + 12), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
					TheDeepVoidMod.queueServerWork(18, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z + 10), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z + 10), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
					TheDeepVoidMod.queueServerWork(28, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z + 8), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z + 8), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
					TheDeepVoidMod.queueServerWork(38, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z + 6), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z + 6), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
					TheDeepVoidMod.queueServerWork(48, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z + 4), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z + 4), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					});
				} else if (Math.random() < 0.1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -32, 32), y, z + Mth.nextInt(RandomSource.create(), -32, 32)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_song_far")), SoundSource.HOSTILE, 2, 1);
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -32, 32)), y, (z + Mth.nextInt(RandomSource.create(), -32, 32)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_song_far")), SoundSource.HOSTILE, 2, 1, false);
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).mistedRemnantAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mistedRemnantAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get())) && !(new Object() {
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
			}.checkGamemode(entity)) && !(!world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) && TheDeepVoidModVariables.MapVariables.get(world).hydraKilled == false
					&& DeepVoidConfigConfiguration.DOBRAINFOG.get() == true) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BRAIN_FOG.get(), (int) (double) DeepVoidConfigConfiguration.BRAINFOGDURATION.get(), 0, false, false));
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:drifting_monoliths"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).monolithAmbience >= 700) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.monolithAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (Math.random() < 0.5) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:stone_dragging ambient @s ~ ~ ~ 2 1 0.5");
						}
					}
				} else if (Math.random() < 0.5) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:stone_impact ambient @s ~ ~ ~ 2 1 0.5");
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).monolithAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.monolithAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).nestAmbience >= 300) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.nestAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (Math.random() < 0.5) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:crawler_nest_additions ambient @s ~ ~ ~ 2 1 0.5");
						}
					}
				} else if (Math.random() < 0.5) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound entity.silverfish.ambient ambient @s ~ ~ ~ 2 1 0.5");
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).nestAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.nestAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gaol_of_heretics")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:the_gaol"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).gaol_ambience >= 500) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gaol_ambience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:swinging_cage ambient @s ~ ~ ~ 4 1 0.5");
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).gaol_ambience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gaol_ambience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
