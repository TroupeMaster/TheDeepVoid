package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;

public class SulfurTntEntityModelVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_fuse) : 0) >= 1) {
			return entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_fuse) : 0;
		}
		return 1;
	}
}
