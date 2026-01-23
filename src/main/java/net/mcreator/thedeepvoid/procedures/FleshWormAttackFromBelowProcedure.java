package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class FleshWormAttackFromBelowProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("attackFromBelow", true);
		if (entity instanceof FleshWormEntity) {
			((FleshWormEntity) entity).setAnimation("animation.fleshWorm_attackFromBelow");
		}
		FleshWormSetTeleportProcedure.execute(world, entity);
		TheDeepVoidMod.queueServerWork(15, () -> {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("playerX")), (entity.getPersistentData().getDouble("playerY")), (entity.getPersistentData().getDouble("playerZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("playerX")), (entity.getPersistentData().getDouble("playerY")), (entity.getPersistentData().getDouble("playerZ")), _ent.getYRot(), _ent.getXRot());
			}
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			FleshWormDamageInAoeProcedure.execute(world, entity);
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			FleshWormSetTeleportProcedure.execute(world, entity);
		});
		TheDeepVoidMod.queueServerWork(30, () -> {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("playerX")), (entity.getPersistentData().getDouble("playerY")), (entity.getPersistentData().getDouble("playerZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("playerX")), (entity.getPersistentData().getDouble("playerY")), (entity.getPersistentData().getDouble("playerZ")), _ent.getYRot(), _ent.getXRot());
			}
		});
		TheDeepVoidMod.queueServerWork(35, () -> {
			FleshWormDamageInAoeProcedure.execute(world, entity);
		});
		TheDeepVoidMod.queueServerWork(35, () -> {
			FleshWormSetTeleportProcedure.execute(world, entity);
		});
		TheDeepVoidMod.queueServerWork(45, () -> {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("playerX")), (entity.getPersistentData().getDouble("playerY")), (entity.getPersistentData().getDouble("playerZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("playerX")), (entity.getPersistentData().getDouble("playerY")), (entity.getPersistentData().getDouble("playerZ")), _ent.getYRot(), _ent.getXRot());
			}
		});
		TheDeepVoidMod.queueServerWork(50, () -> {
			entity.getPersistentData().putBoolean("attackFromBelow", false);
			FleshWormDamageInAoeProcedure.execute(world, entity);
		});
	}
}
