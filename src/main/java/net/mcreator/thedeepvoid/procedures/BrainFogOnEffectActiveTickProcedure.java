package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.FalseHydraSingingEntity;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class BrainFogOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if (TheDeepVoidModVariables.MapVariables.get(world).hydraKilled == false) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()).getDuration() : 0) == 1) {
				BrainFogEffectExpiresProcedure.execute(world, x, y, z, entity);
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants")) && !(!world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty())
					|| new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)) {
				if (entity.isPassenger() && ((entity.getVehicle()) instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()).getAmplifier() : 0) >= 2) {
					entity.stopRiding();
				}
			} else if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get());
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants")) && !(!world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).isEmpty())
					&& !(!world.getEntitiesOfClass(FalseHydraSingingEntity.class, AABB.ofSize(new Vec3(x, y, z), 240, 240, 240), e -> true).isEmpty())
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()).getAmplifier() : 0) >= 4
					&& DeepVoidConfigConfiguration.FALSEHYDRAFROMBRAINFOG.get() == true) {
				if (entity.getPersistentData().getDouble("spawnHydraSing") >= 600) {
					entity.getPersistentData().putDouble("spawnHydraSing", 0);
					rnd = Mth.nextInt(RandomSource.create(), 1, 4);
					if (rnd == 1) {
						if (world.getBiome(BlockPos.containing(x + 60, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants"))) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.FALSE_HYDRA_SINGING.get().spawn(_level, BlockPos.containing(x + 60, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					} else if (rnd == 2) {
						if (world.getBiome(BlockPos.containing(x - 60, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants"))) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.FALSE_HYDRA_SINGING.get().spawn(_level, BlockPos.containing(x - 60, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					} else if (rnd == 3) {
						if (world.getBiome(BlockPos.containing(x, y, z + 60)).is(new ResourceLocation("the_deep_void:misted_remnants"))) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.FALSE_HYDRA_SINGING.get().spawn(_level, BlockPos.containing(x, y, z + 60), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					} else if (rnd == 4) {
						if (world.getBiome(BlockPos.containing(x, y, z - 60)).is(new ResourceLocation("the_deep_void:misted_remnants"))) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.FALSE_HYDRA_SINGING.get().spawn(_level, BlockPos.containing(x, y, z - 60), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("spawnHydraSing", (entity.getPersistentData().getDouble("spawnHydraSing") + 1));
				}
			}
		}
	}
}
