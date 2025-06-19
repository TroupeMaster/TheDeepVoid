package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.WatchingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class StalkingStalkerSpawnsProcedure {
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
		if (DeepVoidConfigConfiguration.STALKINGSTALKERSPAWNS.get() == true) {
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
					if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds")) && !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:staring_hills"))
							&& !world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
						if (y > 0) {
							if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount < (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get()) {
								if (!(!world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 180, 180, 180), e -> true).isEmpty())
										&& !(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING))
										&& !(entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(TheDeepVoidModMobEffects.WEAVER_CURSE))) {
									if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(TheDeepVoidModMobEffects.DEAD_INSIDE)) {
										{
											TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
											_vars.StalkerCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount
													+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.DEAD_INSIDE) ? _livEnt.getEffect(TheDeepVoidModMobEffects.DEAD_INSIDE).getAmplifier() : 0) + 1;
											_vars.syncPlayerVariables(entity);
										}
									} else {
										{
											TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
											_vars.StalkerCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount + 1;
											_vars.syncPlayerVariables(entity);
										}
									}
								}
							}
							if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).stalkWatcherCount >= 125 + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).randomStalkerValue) {
								{
									TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
									_vars.stalkWatcherCount = 0;
									_vars.syncPlayerVariables(entity);
								}
								TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX = entity.getX() + Mth.nextInt(RandomSource.create(), -160, 160);
								TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
								TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ = entity.getZ() + Mth.nextInt(RandomSource.create(), -160, 160);
								TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
								if (!(!world.getEntitiesOfClass(Player.class,
										AABB.ofSize(new Vec3(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ), 60, 60, 60), e -> true).isEmpty())) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = TheDeepVoidModEntities.WATCHING_STALKER.get().spawn(_level,
												BlockPos.containing(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, entity.getY(), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									{
										final Vec3 _center = new Vec3(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ);
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof WatchingStalkerEntity) {
												if (entityiterator instanceof WatchingStalkerEntity) {
													((WatchingStalkerEntity) entityiterator).setAnimation("animation.stalker_digOut");
												}
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 75, 99, false, false));
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75, 99, false, false));
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 75, 99, false, false));
											}
										}
									}
								} else if (!world.getEntitiesOfClass(Player.class,
										AABB.ofSize(new Vec3(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ), 60, 60, 60), e -> true).isEmpty()) {
									{
										TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
										_vars.stalkWatcherCount = 180;
										_vars.syncPlayerVariables(entity);
									}
								}
							} else {
								{
									TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
									_vars.stalkWatcherCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).stalkWatcherCount + 1;
									_vars.syncPlayerVariables(entity);
								}
							}
							if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount >= (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() / 3) {
								if (!world.getEntitiesOfClass(StalkingStalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() == false
										&& !world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty() == false) {
									if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).stalkingCount >= 200 + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).randomStalkerValue) {
										{
											TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
											_vars.stalkingCount = 0;
											_vars.syncPlayerVariables(entity);
										}
										TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX = entity.getX() + Mth.nextInt(RandomSource.create(), -60, 60);
										TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
										TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ = entity.getZ() + Mth.nextInt(RandomSource.create(), -60, 60);
										TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
										if (!(!world
												.getEntitiesOfClass(Player.class,
														AABB.ofSize(new Vec3(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ), 40, 40, 40), e -> true)
												.isEmpty())) {
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = TheDeepVoidModEntities.STALKING_STALKER.get().spawn(_level,
														BlockPos.containing(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, entity.getY(), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ), MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
													entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
												}
											}
											{
												final Vec3 _center = new Vec3(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ);
												List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
												for (Entity entityiterator : _entfound) {
													if (entityiterator instanceof StalkingStalkerEntity) {
														if (entityiterator instanceof StalkingStalkerEntity) {
															((StalkingStalkerEntity) entityiterator).setAnimation("animation.stalker_digOut");
														}
														if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 75, 99, false, false));
														if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75, 99, false, false));
														if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 75, 99, false, false));
													}
												}
											}
										} else if (!world
												.getEntitiesOfClass(Player.class,
														AABB.ofSize(new Vec3(TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnX, (entity.getY()), TheDeepVoidModVariables.MapVariables.get(world).stalkerSpawnZ), 20, 20, 20), e -> true)
												.isEmpty()) {
											{
												TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
												_vars.stalkingCount = 180;
												_vars.syncPlayerVariables(entity);
											}
										}
									} else {
										{
											TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
											_vars.stalkingCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).stalkingCount + 1;
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
	}
}
