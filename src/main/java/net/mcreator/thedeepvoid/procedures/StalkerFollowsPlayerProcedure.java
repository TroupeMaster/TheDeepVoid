package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.Comparator;

public class StalkerFollowsPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("deep_void:counterAttack") == false) {
			if (entity.getPersistentData().getBoolean("deep_void:stalkingPhase") == true || entity.getPersistentData().getBoolean("deep_void:stalkingShy") == true) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).isEmpty()) {
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
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))))
							&& !world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds"))
							&& !world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:staring_hills"))
							&& !world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX()),
									(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY()),
									(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ()), 1.2);
					} else if (world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
							((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
							((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds"))
							|| world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:staring_hills"))
							|| world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 260, 260, 260), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
						if (entity.getPersistentData().getBoolean("deep_void:despawning") == false) {
							entity.getPersistentData().putBoolean("deep_void:despawning", true);
							if (entity instanceof StalkingStalkerEntity) {
								((StalkingStalkerEntity) entity).setAnimation("animation.stalker_digHide");
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 99, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 99, false, false));
							TheDeepVoidMod.queueServerWork(35, () -> {
								if (!entity.level().isClientSide())
									entity.discard();
							});
						}
					}
				}
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).isEmpty()) {
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
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))))
							&& !world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds"))
							&& !world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:staring_hills"))
							&& !world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
					} else if (world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
							((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
							((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds"))
							|| world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:staring_hills"))
							|| world.getBiome(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
						if (entity.getPersistentData().getBoolean("deep_void:despawning") == false) {
							entity.getPersistentData().putBoolean("deep_void:despawning", true);
							if (entity instanceof StalkingStalkerEntity) {
								((StalkingStalkerEntity) entity).setAnimation("animation.stalker_digHide");
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 99, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 99, false, false));
							TheDeepVoidMod.queueServerWork(35, () -> {
								if (!entity.level().isClientSide())
									entity.discard();
							});
						}
					}
				}
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
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
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))))) {
						if (Math.random() < 0.5) {
							entity.getPersistentData().putBoolean("deep_void:counterAttack", true);
							if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						} else {
							entity.getPersistentData().putBoolean("deep_void:despawnable", true);
						}
					}
				}
			}
			if (!world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 40, 40, 40), e -> true).isEmpty()) {
				if (!(!world.getEntitiesOfClass(Player.class,
						AABB.ofSize(new Vec3((((Entity) world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 40, 40, 40), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX()),
								(((Entity) world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 40, 40, 40), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY()),
								(((Entity) world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 40, 40, 40), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())), 10, 10, 10),
						e -> true).isEmpty())) {
					if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 40, 40, 40), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
			if (entity instanceof LivingEntity _livEnt302 && _livEnt302.hasEffect(TheDeepVoidModMobEffects.LOOKING.get()) && entity.getPersistentData().getBoolean("deep_void:lookingRightNow") == true) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 15, 99, false, false));
			}
			if (entity.getPersistentData().getBoolean("deep_void:stalkingShy") == true) {
				if (!(entity instanceof LivingEntity _livEnt307 && _livEnt307.hasEffect(TheDeepVoidModMobEffects.LOOKING.get())) && entity.getPersistentData().getBoolean("deep_void:lookingRightNow") == true) {
					if (entity.getPersistentData().getBoolean("deep_void:checking") == false) {
						entity.getPersistentData().putBoolean("deep_void:checking", true);
						TheDeepVoidMod.queueServerWork(20, () -> {
							if (!(entity instanceof LivingEntity _livEnt311 && _livEnt311.hasEffect(TheDeepVoidModMobEffects.LOOKING.get()))) {
								if (entity instanceof StalkingStalkerEntity) {
									((StalkingStalkerEntity) entity).setAnimation("animation.stalker_digOut");
								}
								entity.getPersistentData().putBoolean("deep_void:checking", false);
								entity.getPersistentData().putBoolean("deep_void:lookingRightNow", false);
								entity.getPersistentData().putBoolean("deep_void:despawning", false);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 75, 99, false, false));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75, 99, false, false));
							} else {
								entity.getPersistentData().putBoolean("deep_void:checking", false);
							}
						});
					}
				}
			}
		} else if (entity.getPersistentData().getBoolean("deep_void:counterAttack") == true) {
			TheDeepVoidMod.queueServerWork(200, () -> {
				entity.getPersistentData().putBoolean("deep_void:counterAttack", false);
			});
		}
		if (entity.isInWall()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 1), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
			}
		}
		if (entity.getPersistentData().getBoolean("deep_void:noPlayerDespawn") == false) {
			if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260, 260, 260), e -> true).isEmpty())) {
				entity.getPersistentData().putBoolean("deep_void:noPlayerDespawn", true);
				TheDeepVoidMod.queueServerWork(80, () -> {
					if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 260, 260, 260), e -> true).isEmpty())) {
						if (!entity.level().isClientSide())
							entity.discard();
					} else {
						entity.getPersistentData().putBoolean("deep_void:noPlayerDespawn", false);
					}
				});
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.MOSSY_BONE_PILE.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.BLOCK_OF_SKULL_PILE.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 1, false, false));
		}
	}
}
