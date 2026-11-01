package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.AmalgamEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerLooksAtStalkingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		if ((new Object() {
			public Entity func(Entity player, double entityReach) {
				double distance = entityReach * entityReach;
				Vec3 eyePos = player.getEyePosition(1.0f);
				HitResult hitResult = entity.pick(entityReach, 1.0f, false);
				if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
					distance = hitResult.getLocation().distanceToSqr(eyePos);
					double blockReach = 5;
					if (distance > blockReach * blockReach) {
						Vec3 pos = hitResult.getLocation();
						hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
					}
				}
				Vec3 viewVec = player.getViewVector(1.0F);
				Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
				AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
				EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
					return !p_234237_.isSpectator();
				}, distance);
				if (entityhitresult != null) {
					Entity entity1 = entityhitresult.getEntity();
					Vec3 targetPos = entityhitresult.getLocation();
					double distanceToTarget = eyePos.distanceToSqr(targetPos);
					if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
						hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
					} else if (distanceToTarget < distance) {
						hitResult = entityhitresult;
					}
				}
				if (hitResult.getType() == HitResult.Type.ENTITY) {
					return ((EntityHitResult) hitResult).getEntity();
				}
				return null;
			}
		}.func(entity, 24)) instanceof AmalgamEntity && !(new Object() {
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
		}.checkGamemode(entity)) && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(((new Object() {
			public Entity func(Entity player, double entityReach) {
				double distance = entityReach * entityReach;
				Vec3 eyePos = player.getEyePosition(1.0f);
				HitResult hitResult = entity.pick(entityReach, 1.0f, false);
				if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
					distance = hitResult.getLocation().distanceToSqr(eyePos);
					double blockReach = 5;
					if (distance > blockReach * blockReach) {
						Vec3 pos = hitResult.getLocation();
						hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
					}
				}
				Vec3 viewVec = player.getViewVector(1.0F);
				Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
				AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
				EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
					return !p_234237_.isSpectator();
				}, distance);
				if (entityhitresult != null) {
					Entity entity1 = entityhitresult.getEntity();
					Vec3 targetPos = entityhitresult.getLocation();
					double distanceToTarget = eyePos.distanceToSqr(targetPos);
					if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
						hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
					} else if (distanceToTarget < distance) {
						hitResult = entityhitresult;
					}
				}
				if (hitResult.getType() == HitResult.Type.ENTITY) {
					return ((EntityHitResult) hitResult).getEntity();
				}
				return null;
			}
		}.func(entity, 24)).getX()), ((new Object() {
			public Entity func(Entity player, double entityReach) {
				double distance = entityReach * entityReach;
				Vec3 eyePos = player.getEyePosition(1.0f);
				HitResult hitResult = entity.pick(entityReach, 1.0f, false);
				if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
					distance = hitResult.getLocation().distanceToSqr(eyePos);
					double blockReach = 5;
					if (distance > blockReach * blockReach) {
						Vec3 pos = hitResult.getLocation();
						hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
					}
				}
				Vec3 viewVec = player.getViewVector(1.0F);
				Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
				AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
				EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
					return !p_234237_.isSpectator();
				}, distance);
				if (entityhitresult != null) {
					Entity entity1 = entityhitresult.getEntity();
					Vec3 targetPos = entityhitresult.getLocation();
					double distanceToTarget = eyePos.distanceToSqr(targetPos);
					if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
						hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
					} else if (distanceToTarget < distance) {
						hitResult = entityhitresult;
					}
				}
				if (hitResult.getType() == HitResult.Type.ENTITY) {
					return ((EntityHitResult) hitResult).getEntity();
				}
				return null;
			}
		}.func(entity, 24)).getY()), ((new Object() {
			public Entity func(Entity player, double entityReach) {
				double distance = entityReach * entityReach;
				Vec3 eyePos = player.getEyePosition(1.0f);
				HitResult hitResult = entity.pick(entityReach, 1.0f, false);
				if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
					distance = hitResult.getLocation().distanceToSqr(eyePos);
					double blockReach = 5;
					if (distance > blockReach * blockReach) {
						Vec3 pos = hitResult.getLocation();
						hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
					}
				}
				Vec3 viewVec = player.getViewVector(1.0F);
				Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
				AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
				EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
					return !p_234237_.isSpectator();
				}, distance);
				if (entityhitresult != null) {
					Entity entity1 = entityhitresult.getEntity();
					Vec3 targetPos = entityhitresult.getLocation();
					double distanceToTarget = eyePos.distanceToSqr(targetPos);
					if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
						hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
					} else if (distanceToTarget < distance) {
						hitResult = entityhitresult;
					}
				}
				if (hitResult.getType() == HitResult.Type.ENTITY) {
					return ((EntityHitResult) hitResult).getEntity();
				}
				return null;
			}
		}.func(entity, 24)).getZ())), 30, 30, 30), e -> true).isEmpty())) {
			if ((new Object() {
				public Entity func(Entity player, double entityReach) {
					double distance = entityReach * entityReach;
					Vec3 eyePos = player.getEyePosition(1.0f);
					HitResult hitResult = entity.pick(entityReach, 1.0f, false);
					if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
						distance = hitResult.getLocation().distanceToSqr(eyePos);
						double blockReach = 5;
						if (distance > blockReach * blockReach) {
							Vec3 pos = hitResult.getLocation();
							hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
						}
					}
					Vec3 viewVec = player.getViewVector(1.0F);
					Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
					AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
					EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
						return !p_234237_.isSpectator();
					}, distance);
					if (entityhitresult != null) {
						Entity entity1 = entityhitresult.getEntity();
						Vec3 targetPos = entityhitresult.getLocation();
						double distanceToTarget = eyePos.distanceToSqr(targetPos);
						if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
							hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
						} else if (distanceToTarget < distance) {
							hitResult = entityhitresult;
						}
					}
					if (hitResult.getType() == HitResult.Type.ENTITY) {
						return ((EntityHitResult) hitResult).getEntity();
					}
					return null;
				}
			}.func(entity, 24)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 5, false, false));
		}
	}
}
