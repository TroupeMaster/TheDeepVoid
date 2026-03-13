package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.PenitentEntity;

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
