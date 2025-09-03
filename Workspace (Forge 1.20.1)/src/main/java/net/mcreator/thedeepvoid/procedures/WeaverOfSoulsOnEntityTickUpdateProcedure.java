package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class WeaverOfSoulsOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).isEmpty()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) && entity.getPersistentData().getBoolean("deep_void:stunned") == false) {
			if (entity.getPersistentData().getDouble("deep_void:locate_cooldown") >= 80) {
				entity.getPersistentData().putDouble("deep_void:locate_cooldown", 0);
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).isEmpty()
						&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())) {
					TheDeepVoidMod.queueServerWork(40, () -> {
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).isEmpty()
								&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())) {
							if (!((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).isShiftKeyDown()) {
								if (entity instanceof Mob _entity)
									_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + Mth.nextInt(RandomSource.create(), -20, 20)), (entity.getY()),
											(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 80, 80, 80), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + Mth.nextInt(RandomSource.create(), -20, 20)), 1);
							}
						}
					});
				}
			} else {
				entity.getPersistentData().putDouble("deep_void:locate_cooldown", (entity.getPersistentData().getDouble("deep_void:locate_cooldown") + 1));
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).isEmpty()) {
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
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
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
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)))) && entity.getPersistentData().getBoolean("deep_void:stunned") == false) {
				if (!(!world.getEntitiesOfClass(WeaverOfSoulsEntity.class,
						AABB.ofSize(new Vec3((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX()),
								(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY()),
								(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())), 10, 10, 10),
						e -> true).isEmpty())) {
					if (entity.getPersistentData().getDouble("deep_void:hands_cooldown") >= 140) {
						entity.getPersistentData().putDouble("deep_void:hands_cooldown", 0);
						if (!(!world.getEntitiesOfClass(WeaverOfSoulsEntity.class,
								AABB.ofSize(new Vec3((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX()),
										(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY()),
										(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())), 10, 10, 10),
								e -> true).isEmpty())) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
										BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
												((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
												((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ()),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + 1,
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + 1,
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ()),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() - 1,
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ())).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() - 1,
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ()),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() - 1)).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() - 1),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + 1)).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + 1),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + 1,
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + 1)).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + 1,
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + 1),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() - 1,
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() - 1)).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() - 1,
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() - 1),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + 1,
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() - 1)).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() + 1,
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() - 1),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
							if (!world.getBlockState(BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() - 1,
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
									((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + 1)).canOcclude()) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = TheDeepVoidModEntities.HAND_SPAWN.get().spawn(_level,
											BlockPos.containing(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX() - 1,
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ() + 1),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
					} else {
						entity.getPersistentData().putDouble("deep_void:hands_cooldown", (entity.getPersistentData().getDouble("deep_void:hands_cooldown") + 1));
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:screamCooldown") > 0) {
			entity.getPersistentData().putDouble("deep_void:screamCooldown", (entity.getPersistentData().getDouble("deep_void:screamCooldown") - 1));
		}
		if (entity.getPersistentData().getDouble("deep_void:screamCooldown") <= 0 && entity.getPersistentData().getBoolean("deep_void:screamPlayed") == true) {
			entity.getPersistentData().putBoolean("deep_void:screamPlayed", false);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (entity.getPersistentData().getBoolean("deep_void:stunned") == false) {
				if (entity.getPersistentData().getDouble("deep_void:handWall") >= 400) {
					entity.getPersistentData().putDouble("deep_void:handWall", 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sculk_shrieker.shriek")), SoundSource.HOSTILE, 4, (float) 0.8);
						} else {
							_level.playLocalSound((entity.getPersistentData().getDouble("deep_void:startingX")), (entity.getPersistentData().getDouble("deep_void:startingY")), (entity.getPersistentData().getDouble("deep_void:startingZ")),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sculk_shrieker.shriek")), SoundSource.HOSTILE, 4, (float) 0.8, false);
						}
					}
					entity.getPersistentData().putDouble("deep_void:randomChoice", (Mth.nextInt(RandomSource.create(), 1, 4)));
					if (entity.getPersistentData().getDouble("deep_void:randomChoice") == 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 2, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 4, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 8, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 10, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 12, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 14, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 16, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 18, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 20, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					if (entity.getPersistentData().getDouble("deep_void:randomChoice") == 2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 2, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 4, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 8, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 10, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 12, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 14, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 16, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 18, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 20, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					if (entity.getPersistentData().getDouble("deep_void:randomChoice") == 3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 2),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 4),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 8),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 10),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 12),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 14),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 16),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 18),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 20),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					if (entity.getPersistentData().getDouble("deep_void:randomChoice") == 4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 2),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 4),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 8),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 10),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 12),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 14),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 16),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 18),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 20),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("deep_void:handWall", (entity.getPersistentData().getDouble("deep_void:handWall") + 1));
				}
			}
		}
		if (entity.getPersistentData().getBoolean("deep_void:stunned") == true) {
			if (entity instanceof WeaverOfSoulsEntity) {
				((WeaverOfSoulsEntity) entity).setAnimation("animation.fallenWeaver_stun");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 0, false, false));
			if (entity.getPersistentData().getDouble("deep_void:stunCount") >= 200) {
				entity.getPersistentData().putBoolean("deep_void:stunned", false);
				entity.getPersistentData().putDouble("deep_void:stunCount", 0);
				if (entity instanceof WeaverOfSoulsEntity) {
					((WeaverOfSoulsEntity) entity).setAnimation("animation.fallenWeaver_attack");
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entityiterator.getYRot() + 180)) * (-2.4)), 0.6, (Math.cos(Math.toRadians(entityiterator.getYRot())) * (-2.4))));
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 5);
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("deep_void:stunCount", (entity.getPersistentData().getDouble("deep_void:stunCount") + 1));
			}
		} else {
			if (entity instanceof WeaverOfSoulsEntity) {
				((WeaverOfSoulsEntity) entity).setAnimation("empty");
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 90, 90, 90), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(90 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 20, 0, false, false));
					}
				}
			}
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 90, 90, 90), e -> true).isEmpty())
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (entity.getPersistentData().getBoolean("deep_void:blockade") == false) {
				entity.getPersistentData().putBoolean("deep_void:blockade", true);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else if (Math.random() < 0.3) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else if (Math.random() < 0.3) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") - 1, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 6),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") + 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.LASTING_SHADOW_HAND.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX") + 6, entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ") - 1),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
			if (!(entity instanceof LivingEntity _livEnt669 && _livEnt669.hasEffect(TheDeepVoidModMobEffects.DARKMARE_MUSIC.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.DARKMARE_MUSIC.get(), 3300, 0, false, false));
			}
			if (entity.getPersistentData().getDouble("deep_void:murmurs") >= 800) {
				entity.getPersistentData().putDouble("deep_void:murmurs", 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:ominous_murmurs")), SoundSource.AMBIENT, 3, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:ominous_murmurs")), SoundSource.AMBIENT, 3, 1, false);
					}
				}
			} else {
				entity.getPersistentData().putDouble("deep_void:murmurs", (entity.getPersistentData().getDouble("deep_void:murmurs") + 1));
			}
		} else {
			if (entity instanceof LivingEntity _livEnt679 && _livEnt679.hasEffect(TheDeepVoidModMobEffects.DARKMARE_MUSIC.get())) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TheDeepVoidModMobEffects.DARKMARE_MUSIC.get());
			}
		}
	}
}
