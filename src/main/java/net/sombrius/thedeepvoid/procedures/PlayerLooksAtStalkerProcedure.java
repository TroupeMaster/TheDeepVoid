package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.sombrius.thedeepvoid.entity.StalkerEntity;

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
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerLooksAtStalkerProcedure {
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
		}.func(entity, 64)) instanceof StalkerEntity && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(((new Object() {
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
		}.func(entity, 64)).getX()), ((new Object() {
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
		}.func(entity, 64)).getY()), ((new Object() {
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
		}.func(entity, 64)).getZ())), 28, 28, 28), e -> true).isEmpty()) && !(entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MobEffects.BLINDNESS))
				&& !(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.DARKNESS))) {
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
			}.func(entity, 64)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.STARE.get(), 5, 0, false, false));
		}
	}
}
