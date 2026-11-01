package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.WatchingStalkerEntity;

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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

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
		}.func(entity, 64)) instanceof WatchingStalkerEntity && !(new Object() {
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
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants"))) {
				if (!(new Object() {
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
				}.func(entity, 64)).level().isClientSide())
					(new Object() {
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
					}.func(entity, 64)).discard();
			} else if ((new Object() {
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
			}.func(entity, 64)).getPersistentData().getBoolean("despawning") == false) {
				(new Object() {
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
				}.func(entity, 64)).getPersistentData().putBoolean("despawning", true);
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
				}.func(entity, 64)) instanceof WatchingStalkerEntity) {
					((WatchingStalkerEntity) (new Object() {
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
					}.func(entity, 64))).setAnimation("animation.stalker_hide");
				}
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
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
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
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 99, false, false));
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
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 99, false, false));
			}
		}
	}
}
