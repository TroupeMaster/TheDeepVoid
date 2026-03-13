package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;

public class MaskedHunterPlaceTrapProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof MaskedHunterEntity _datEntI ? _datEntI.getEntityData().get(MaskedHunterEntity.DATA_placeTrap) : 0) <= 0) {
			if (entity instanceof MaskedHunterEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MaskedHunterEntity.DATA_placeTrap, 400);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.BONE_CAGE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else {
			if (entity instanceof MaskedHunterEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MaskedHunterEntity.DATA_placeTrap, (int) ((entity instanceof MaskedHunterEntity _datEntI ? _datEntI.getEntityData().get(MaskedHunterEntity.DATA_placeTrap) : 0) - 1));
		}
	}
}
