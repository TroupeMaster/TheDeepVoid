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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.WatchingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PlayerInDarknessNearTheStalkerProcedure {
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
		double randomX = 0;
		double randomY = 0;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			if (!(new Object() {
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
				if (!(!world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 180, 180, 180), e -> true).isEmpty())) {
					if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 1) {
						if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount >= (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get()) {
							{
								double _setval = 0;
								entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StalkerCount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (DeepVoidConfigConfiguration.STALKERSPAWNS.get() == true) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof StalkingStalkerEntity) {
											if (entityiterator instanceof StalkingStalkerEntity) {
												((StalkingStalkerEntity) entityiterator).setAnimation("animation.stalker_digHide");
											}
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 45, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 45, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 45, 99, false, false));
											TheDeepVoidMod.queueServerWork(35, () -> {
												if (!entityiterator.level().isClientSide())
													entityiterator.discard();
											});
										}
										if (entityiterator instanceof WatchingStalkerEntity) {
											if (entityiterator instanceof WatchingStalkerEntity) {
												((WatchingStalkerEntity) entityiterator).setAnimation("animation.stalker_digHide");
											}
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 45, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 45, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 45, 99, false, false));
											TheDeepVoidMod.queueServerWork(35, () -> {
												if (!entityiterator.level().isClientSide())
													entityiterator.discard();
											});
										}
									}
								}
								TheDeepVoidMod.queueServerWork(55, () -> {
									TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX = entity.getX() + Mth.nextInt(RandomSource.create(), -25, 25);
									TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
									TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ = entity.getZ() + Mth.nextInt(RandomSource.create(), -25, 25);
									TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = TheDeepVoidModEntities.STALKER.get().spawn(_level,
												BlockPos.containing(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, entity.getY(), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, entity.getY(), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ),
													ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_emerges_new")), SoundSource.HOSTILE, 8, 1);
										} else {
											_level.playLocalSound(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ,
													ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_emerges_new")), SoundSource.HOSTILE, 8, 1, false);
										}
									}
									{
										final Vec3 _center = new Vec3(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ);
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof StalkerEntity) {
												((StalkerEntity) entityiterator).setAnimation("animation.stalker_digOut");
											}
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 75, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 75, 99, false, false));
										}
									}
								});
							}
						}
					} else {
						if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount > 0) {
							{
								double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount - 2;
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
}
