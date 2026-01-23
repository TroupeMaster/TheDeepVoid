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
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HivemindTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomX = 0;
		double randomZ = 0;
		entity.setDeltaMovement(new Vec3(0, 0, 0));
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			entity.getPersistentData().putDouble("deep_void:attackChance", (entity.getPersistentData().getDouble("deep_void:attackChance") + 1));
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 40) {
			HivemindFangsCrossProcedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 140 && entity.getPersistentData().getDouble("sawThrowerCooldown") <= 0) {
			HivemindSummonSawThrowerProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 220) {
			HivemindFangsDiagonalProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 300 && entity.getPersistentData().getDouble("skullSmasherCooldown") <= 0) {
			HivemindSummonSmasherProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 360) {
			HivemindHealProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("deep_void:attackChance") == 400) {
			entity.getPersistentData().putDouble("deep_void:attackChance", 0);
		}
		if (entity.getPersistentData().getDouble("sawThrowerCooldown") > 0) {
			entity.getPersistentData().putDouble("sawThrowerCooldown", (entity.getPersistentData().getDouble("sawThrowerCooldown") - 1));
		}
		if (entity.getPersistentData().getDouble("skullSmasherCooldown") > 0) {
			entity.getPersistentData().putDouble("skullSmasherCooldown", (entity.getPersistentData().getDouble("skullSmasherCooldown") - 1));
		}
		if (entity.getPersistentData().getDouble("fleshTentaclesCooldown") > 0) {
			entity.getPersistentData().putDouble("fleshTentaclesCooldown", (entity.getPersistentData().getDouble("fleshTentaclesCooldown") - 1));
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_BRAIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:pitch_black");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:pitch_black");
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
