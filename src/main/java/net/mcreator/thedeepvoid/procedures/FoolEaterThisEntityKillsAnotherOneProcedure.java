package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.FoolEaterEntity;

public class FoolEaterThisEntityKillsAnotherOneProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof FoolEaterEntity _datEntL0 && _datEntL0.getEntityData().get(FoolEaterEntity.DATA_cracked)) == true) {
			if (sourceentity instanceof FoolEaterEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FoolEaterEntity.DATA_cracked, false);
		}
	}
}
