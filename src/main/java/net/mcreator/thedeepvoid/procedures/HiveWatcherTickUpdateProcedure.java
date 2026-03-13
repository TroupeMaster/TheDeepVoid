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
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
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
				if (entity instanceof HiveWatcherEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HiveWatcherEntity.DATA_attackChance, (int) ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) + 2));
			} else {
				if (entity instanceof HiveWatcherEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HiveWatcherEntity.DATA_attackChance, (int) ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) + 1));
			}
		}
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 40) {
			HiveWatcherMoveInXProcedure.execute(world, entity);
		}
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 78) {
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
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 80) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageX, false);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageZ, false);
			entity.getPersistentData().putDouble("speedBuildUp", 0);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spinning, true);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spawnBlockade, false);
			HiveWatcherSpinProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 100) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spinning, false);
			HiveWatcherMoveInZProcedure.execute(world, entity);
		}
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 138) {
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
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 140) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageX, false);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageZ, false);
			entity.getPersistentData().putDouble("speedBuildUp", 0);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spinning, true);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spawnBlockade, false);
			HiveWatcherSpinProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 160) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spinning, false);
			HiveWatcherMoveInDiagonalProcedure.execute(world, entity);
		}
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 198) {
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
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) == 200) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageX, false);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_damageZ, false);
			entity.getPersistentData().putDouble("speedBuildUp", 0);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spinning, true);
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spawnBlockade, false);
			HiveWatcherSpinProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof HiveWatcherEntity _datEntI ? _datEntI.getEntityData().get(HiveWatcherEntity.DATA_attackChance) : 0) >= 220) {
			if (entity instanceof HiveWatcherEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HiveWatcherEntity.DATA_spinning, false);
			if (entity instanceof HiveWatcherEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HiveWatcherEntity.DATA_attackChance, 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if ((entity instanceof HiveWatcherEntity _datEntL58 && _datEntL58.getEntityData().get(HiveWatcherEntity.DATA_damageX)) == true
					&& (entity instanceof HiveWatcherEntity _datEntL59 && _datEntL59.getEntityData().get(HiveWatcherEntity.DATA_damageZ)) == false) {
				HiveWatcherWhileMovingXProcedure.execute(world, x, y, z, entity);
			} else if ((entity instanceof HiveWatcherEntity _datEntL60 && _datEntL60.getEntityData().get(HiveWatcherEntity.DATA_damageZ)) == true
					&& (entity instanceof HiveWatcherEntity _datEntL61 && _datEntL61.getEntityData().get(HiveWatcherEntity.DATA_damageX)) == false) {
				HiveWatcherWhileMovingZProcedure.execute(world, x, y, z, entity);
			} else if ((entity instanceof HiveWatcherEntity _datEntL62 && _datEntL62.getEntityData().get(HiveWatcherEntity.DATA_damageX)) == true
					&& (entity instanceof HiveWatcherEntity _datEntL63 && _datEntL63.getEntityData().get(HiveWatcherEntity.DATA_damageZ)) == true) {
				HiveWatcherWhileMovingDiagonalProcedure.execute(world, x, y, z, entity);
			}
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) && DeepVoidConfigConfiguration.BOSSIDLES.get() == true) {
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
