package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.VoidbornEntity;

public class VoidbornBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity instanceof VoidbornEntity _datEntL0 && _datEntL0.getEntityData().get(VoidbornEntity.DATA_crouch)) == true) {
			return 0.45;
		} else if ((entity instanceof VoidbornEntity _datEntL1 && _datEntL1.getEntityData().get(VoidbornEntity.DATA_crouch)) == false) {
			return 1;
		}
		return 1;
	}
}
