package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class SwarmerTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity.getPersistentData().getDouble("deep_void:swarmerCooldown") >= 40) {
			entity.getPersistentData().putDouble("deep_void:swarmerCooldown", 0);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.18),
						(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) * 0.18), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.18)));
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:swarmerCooldown", (entity.getPersistentData().getDouble("deep_void:swarmerCooldown") + 1));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getY() > (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 6) {
				entity.setDeltaMovement(new Vec3(0, (-0.015), 0));
			}
		}
	}
}
