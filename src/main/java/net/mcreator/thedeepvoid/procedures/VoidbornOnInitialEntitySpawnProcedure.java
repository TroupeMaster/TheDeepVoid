package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.VoidbornEntity;

public class VoidbornOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof VoidbornEntity _datEntSetI)
			_datEntSetI.getEntityData().set(VoidbornEntity.DATA_crouching, 1);
	}
}
