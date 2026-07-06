package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.StalkerJuvenileEntity;

public class StalkerJuvenileEntityIsHurtProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof StalkerJuvenileEntity && (entity instanceof StalkerJuvenileEntity _datEntL1 && _datEntL1.getEntityData().get(StalkerJuvenileEntity.DATA_runAway)) == true) {
			if (entity instanceof StalkerJuvenileEntity _datEntSetL)
				_datEntSetL.getEntityData().set(StalkerJuvenileEntity.DATA_runAway, false);
		} else if (!(sourceentity instanceof StalkerJuvenileEntity) && (entity instanceof StalkerJuvenileEntity _datEntL4 && _datEntL4.getEntityData().get(StalkerJuvenileEntity.DATA_runAway)) == false) {
			if (entity instanceof StalkerJuvenileEntity _datEntSetL)
				_datEntSetL.getEntityData().set(StalkerJuvenileEntity.DATA_runAway, true);
		}
	}
}
