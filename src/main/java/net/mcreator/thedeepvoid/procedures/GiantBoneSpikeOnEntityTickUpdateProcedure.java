package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;
import net.mcreator.thedeepvoid.entity.GiantBoneSpikeEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class GiantBoneSpikeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWall()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 1), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
			}
		}
		if (entity.isInWaterOrBubble()) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if ((entity instanceof GiantBoneSpikeEntity _datEntI ? _datEntI.getEntityData().get(GiantBoneSpikeEntity.DATA_despawn) : 0) >= 200) {
			if (entity instanceof GiantBoneSpikeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GiantBoneSpikeEntity.DATA_despawn, 0);
			if (entity instanceof GiantBoneSpikeEntity) {
				((GiantBoneSpikeEntity) entity).setAnimation("animation.giantSpike_despawn");
			}
			TheDeepVoidMod.queueServerWork(10, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		} else {
			if (entity instanceof GiantBoneSpikeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GiantBoneSpikeEntity.DATA_despawn, (int) ((entity instanceof GiantBoneSpikeEntity _datEntI ? _datEntI.getEntityData().get(GiantBoneSpikeEntity.DATA_despawn) : 0) + 1));
		}
		if (!world.getEntitiesOfClass(MaskedHunterEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.5, 1.5, 1.5), e -> true).isEmpty()) {
			if ((entity instanceof GiantBoneSpikeEntity _datEntI ? _datEntI.getEntityData().get(GiantBoneSpikeEntity.DATA_despawn) : 0) < 200) {
				if (entity instanceof GiantBoneSpikeEntity _datEntSetI)
					_datEntSetI.getEntityData().set(GiantBoneSpikeEntity.DATA_despawn, 200);
			}
		}
	}
}
