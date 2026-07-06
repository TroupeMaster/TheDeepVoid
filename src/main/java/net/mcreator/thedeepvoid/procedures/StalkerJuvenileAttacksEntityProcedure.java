package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.WatchingStalkerEntity;
import net.mcreator.thedeepvoid.entity.StalkerJuvenileEntity;
import net.mcreator.thedeepvoid.entity.StalkerEntity;

public class StalkerJuvenileAttacksEntityProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof StalkerEntity || (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof WatchingStalkerEntity
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof StalkerJuvenileEntity) {
				return false;
			}
		}
		return true;
	}
}
