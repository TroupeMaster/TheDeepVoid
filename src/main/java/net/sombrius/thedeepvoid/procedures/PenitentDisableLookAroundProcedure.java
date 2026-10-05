package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.PenitentEntity;

import net.minecraft.world.entity.Entity;

public class PenitentDisableLookAroundProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof PenitentEntity _datEntL0 && _datEntL0.getEntityData().get(PenitentEntity.DATA_praying)) == false) {
			return true;
		}
		return false;
	}
}
