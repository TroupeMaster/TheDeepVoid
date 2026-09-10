package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.DarkSteelFlailEntity;

public class DarkSteelFlailDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof DarkSteelFlailEntity _datEntL0 && _datEntL0.getEntityData().get(DarkSteelFlailEntity.DATA_secret)) == true) {
			return true;
		}
		return false;
	}
}
