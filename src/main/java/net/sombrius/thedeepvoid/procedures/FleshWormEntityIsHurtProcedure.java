package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.FleshWormEntity;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class FleshWormEntityIsHurtProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null || (entity instanceof FleshWormEntity _datEntL2 && _datEntL2.getEntityData().get(FleshWormEntity.DATA_spawning)) == true) {
			return false;
		}
		return true;
	}
}
