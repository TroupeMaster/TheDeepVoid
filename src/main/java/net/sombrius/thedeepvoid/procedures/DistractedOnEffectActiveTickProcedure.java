package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.StalkerEntity;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class DistractedOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof StalkerEntity) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("deep_void:xTreat")), (entity.getPersistentData().getDouble("deep_void:yTreat")), (entity.getPersistentData().getDouble("deep_void:zTreat")), 1.1);
		}
	}
}
