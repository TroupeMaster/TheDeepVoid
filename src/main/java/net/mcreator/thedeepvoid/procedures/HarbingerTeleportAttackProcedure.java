package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;

public class HarbingerTeleportAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if ((entity instanceof HarbingerOfCataclysmEntity _datEntL0 && _datEntL0.getEntityData().get(HarbingerOfCataclysmEntity.DATA_teleportAttack)) == true) {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_teleportAttack, false);
			rnd = Mth.nextInt(RandomSource.create(), 1, 3);
			if (rnd == 1) {
				HarbingerGroundPoundProcedure.execute(world, x, y, z, entity);
			} else if (rnd == 2) {
				HarbingerTeleportSlashProcedure.execute(world, entity);
			} else if (rnd == 3) {
				HarbingerTeleportPierceProcedure.execute(world, entity);
			}
		}
	}
}
