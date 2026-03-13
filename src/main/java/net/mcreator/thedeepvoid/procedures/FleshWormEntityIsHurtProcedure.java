package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.FleshWormEntity;

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
