package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.DarkSteelFlailEntity;

import net.minecraft.world.entity.Entity;

public class DarkSteelFlailDisplayCondition2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof DarkSteelFlailEntity _datEntL0 && _datEntL0.getEntityData().get(DarkSteelFlailEntity.DATA_secret)) == false) {
			return true;
		}
		return false;
	}
}
