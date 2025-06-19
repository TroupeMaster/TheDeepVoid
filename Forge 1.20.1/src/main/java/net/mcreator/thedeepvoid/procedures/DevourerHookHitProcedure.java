package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class DevourerHookHitProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(sourceentity == null)) {
			entity.setDeltaMovement(new Vec3(((sourceentity.getX() - entity.getX()) * 0.3), ((sourceentity.getY() - entity.getY()) * 0.3), ((sourceentity.getZ() - entity.getZ()) * 0.3)));
		}
	}
}
