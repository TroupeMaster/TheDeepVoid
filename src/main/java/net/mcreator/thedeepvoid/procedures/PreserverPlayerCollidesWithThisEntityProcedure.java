package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.PreserverEntity;

public class PreserverPlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (sourceentity == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
				if (entity instanceof PreserverEntity _datEntSetL)
					_datEntSetL.getEntityData().set(PreserverEntity.DATA_cling, true);
				if (entity instanceof PreserverEntity) {
					((PreserverEntity) entity).setAnimation("animation.preserver_cling");
				}
			}
		}
	}
}
