package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HarbingerParryProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
			_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, true);
		if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
			_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_parry, 30);
		if (entity instanceof HarbingerOfCataclysmEntity) {
			((HarbingerOfCataclysmEntity) entity).setAnimation("empty");
		}
		if (entity instanceof HarbingerOfCataclysmEntity) {
			((HarbingerOfCataclysmEntity) entity).setAnimation("animation.harbinger_parry");
		}
		TheDeepVoidMod.queueServerWork(35, () -> {
			if ((entity instanceof HarbingerOfCataclysmEntity _datEntL4 && _datEntL4.getEntityData().get(HarbingerOfCataclysmEntity.DATA_attacking)) == true) {
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, false);
			}
		});
	}
}
