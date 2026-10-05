package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.LickerEntity;

import net.minecraft.world.entity.Entity;

public class LickerEntityIsHurtProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getVehicle()) == entity) {
			if (Math.random() < 0.05 && (entity instanceof LickerEntity _datEntL2 && _datEntL2.getEntityData().get(LickerEntity.DATA_stunned)) == false) {
				if (entity instanceof LickerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(LickerEntity.DATA_stunned, true);
				if (entity instanceof LickerEntity) {
					((LickerEntity) entity).setAnimation("empty");
				}
				if (entity instanceof LickerEntity) {
					((LickerEntity) entity).setAnimation("animation.licker_stun");
				}
			}
		} else {
			if (Math.random() < 0.25 && (entity instanceof LickerEntity _datEntL6 && _datEntL6.getEntityData().get(LickerEntity.DATA_stunned)) == false) {
				if (entity instanceof LickerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(LickerEntity.DATA_stunned, true);
				if (entity instanceof LickerEntity) {
					((LickerEntity) entity).setAnimation("empty");
				}
				if (entity instanceof LickerEntity) {
					((LickerEntity) entity).setAnimation("animation.licker_stun");
				}
			}
		}
	}
}
