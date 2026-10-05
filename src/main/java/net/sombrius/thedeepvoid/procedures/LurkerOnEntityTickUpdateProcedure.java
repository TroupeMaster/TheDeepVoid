package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.LurkerEntity;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class LurkerOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity instanceof LurkerEntity) {
				((LurkerEntity) entity).setAnimation("animation.lurker_idle");
			}
		} else if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			if (entity instanceof LurkerEntity) {
				((LurkerEntity) entity).setAnimation("empty");
			}
		}
	}
}
