package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HiveWatcherTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / (double) DeepVoidConfigConfiguration.HIVEWATCHERSECONDPHASE.get()) {
				entity.getPersistentData().putDouble("deep_void:attackChance", (entity.getPersistentData().getDouble("deep_void:attackChance") + 2));
			} else {
				entity.getPersistentData().putDouble("deep_void:attackChance", (entity.getPersistentData().getDouble("deep_void:attackChance") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 40) {
			HiveWatcherMoveInXProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 78) {
			if (Math.random() < (double) DeepVoidConfigConfiguration.HIVEWATCHERFANGSSPAWN.get()) {
				HiveWatcherHiveFangsProcedure.execute(world, entity);
			}
			if (Math.random() < (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIKESPAWN.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.SPAWN_BONE_SPIKES.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 80) {
			entity.getPersistentData().putBoolean("damageX", false);
			entity.getPersistentData().putBoolean("damageZ", false);
			entity.getPersistentData().putDouble("speedBuildUp", 0);
			entity.getPersistentData().putBoolean("spinning", true);
			entity.getPersistentData().putBoolean("spawnBlockade", false);
			HiveWatcherSpinProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 100) {
			entity.getPersistentData().putBoolean("spinning", false);
			HiveWatcherMoveInZProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 138) {
			if (Math.random() < (double) DeepVoidConfigConfiguration.HIVEWATCHERFANGSSPAWN.get()) {
				HiveWatcherHiveFangsProcedure.execute(world, entity);
			}
			if (Math.random() < (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIKESPAWN.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.SPAWN_BONE_SPIKES.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 140) {
			entity.getPersistentData().putBoolean("damageX", false);
			entity.getPersistentData().putBoolean("damageZ", false);
			entity.getPersistentData().putDouble("speedBuildUp", 0);
			entity.getPersistentData().putBoolean("spinning", true);
			entity.getPersistentData().putBoolean("spawnBlockade", false);
			HiveWatcherSpinProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 160) {
			entity.getPersistentData().putBoolean("spinning", false);
			HiveWatcherMoveInDiagonalProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 198) {
			if (Math.random() < (double) DeepVoidConfigConfiguration.HIVEWATCHERFANGSSPAWN.get()) {
				HiveWatcherHiveFangsProcedure.execute(world, entity);
			}
			if (Math.random() < (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIKESPAWN.get()) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.SPAWN_BONE_SPIKES.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 200) {
			entity.getPersistentData().putBoolean("damageX", false);
			entity.getPersistentData().putBoolean("damageZ", false);
			entity.getPersistentData().putDouble("speedBuildUp", 0);
			entity.getPersistentData().putBoolean("spinning", true);
			entity.getPersistentData().putBoolean("spawnBlockade", false);
			HiveWatcherSpinProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") >= 220) {
			entity.getPersistentData().putBoolean("spinning", false);
			entity.getPersistentData().putDouble("deep_void:attackChance", 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity.getPersistentData().getBoolean("damageX") == true && entity.getPersistentData().getBoolean("damageZ") == false) {
				HiveWatcherWhileMovingXProcedure.execute(world, x, y, z, entity);
			} else if (entity.getPersistentData().getBoolean("damageZ") == true && entity.getPersistentData().getBoolean("damageX") == false) {
				HiveWatcherWhileMovingZProcedure.execute(world, x, y, z, entity);
			} else if (entity.getPersistentData().getBoolean("damageX") == true && entity.getPersistentData().getBoolean("damageZ") == true) {
				HiveWatcherWhileMovingDiagonalProcedure.execute(world, x, y, z, entity);
			}
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.EYE_OF_THE_WATCHER.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("deep_void:startingX"), entity.getPersistentData().getDouble("deep_void:startingY"), entity.getPersistentData().getDouble("deep_void:startingZ")),
						MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:monsters_lair");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:monsters_lair");
			});
		}
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
					}
				}
			}
		}
	}
}
