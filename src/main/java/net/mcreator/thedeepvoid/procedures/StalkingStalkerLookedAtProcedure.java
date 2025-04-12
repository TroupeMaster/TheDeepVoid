package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class StalkingStalkerLookedAtProcedure {
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
		double distance = 0;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (!world.getEntitiesOfClass(StalkingStalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 250, 250, 250), e -> true).isEmpty()) {
				distance = 1;
				for (int index0 = 0; index0 < 20; index0++) {
					{
						final Vec3 _center = new Vec3((entity.getX() + entity.getLookAngle().x * distance), (entity.getY() + entity.getLookAngle().y * distance), (entity.getZ() + entity.getLookAngle().z * distance));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof StalkingStalkerEntity) {
								if (entityiterator.getPersistentData().getBoolean("deep_void:counterAttack") == false) {
									if (entityiterator.getPersistentData().getBoolean("deep_void:despawnable") == true) {
										if (entityiterator.getPersistentData().getBoolean("deep_void:despawning") == false) {
											entityiterator.getPersistentData().putBoolean("deep_void:despawning", true);
											if (entityiterator instanceof StalkingStalkerEntity) {
												((StalkingStalkerEntity) entityiterator).setAnimation("animation.stalker_digHide");
											}
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 99, false, false));
											TheDeepVoidMod.queueServerWork(35, () -> {
												if (Math.random() < 0.4) {
													entityiterator.getPersistentData().putBoolean("deep_void:lookingRightNow", true);
													entityiterator.getPersistentData().putBoolean("deep_void:stalkingShy", true);
												} else {
													if (!entityiterator.level().isClientSide())
														entityiterator.discard();
												}
											});
										}
									}
									if (entityiterator.getPersistentData().getBoolean("deep_void:stalkingShy") == true) {
										if (entityiterator.getPersistentData().getBoolean("deep_void:despawning") == false) {
											entityiterator.getPersistentData().putBoolean("deep_void:despawning", true);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 99, false, false));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 99, false, false));
											if (entityiterator instanceof StalkingStalkerEntity) {
												((StalkingStalkerEntity) entityiterator).setAnimation("animation.stalker_digHide");
											}
											TheDeepVoidMod.queueServerWork(35, () -> {
												entityiterator.getPersistentData().putBoolean("deep_void:lookingRightNow", true);
											});
										}
										if (entityiterator.getPersistentData().getBoolean("deep_void:lookingRightNow") == true) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.LOOKING.get(), 80, 0, false, false));
										}
									}
									if (entityiterator.getPersistentData().getBoolean("deep_void:stalkingPhase") == true && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty() == false) {
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
									}
								}
							}
						}
					}
					distance = distance + 1;
				}
			}
		}
	}
}
