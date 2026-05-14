package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.MadCultistEntity;

public class MadCultistLookAroundConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof MadCultistEntity _datEntL0 && _datEntL0.getEntityData().get(MadCultistEntity.DATA_aggressive)) == false
				&& (entity instanceof MadCultistEntity _datEntL1 && _datEntL1.getEntityData().get(MadCultistEntity.DATA_patrol)) == false) {
			return false;
		}
		return true;
	}
}
