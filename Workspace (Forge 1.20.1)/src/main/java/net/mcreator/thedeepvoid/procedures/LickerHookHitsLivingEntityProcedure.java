package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class LickerHookHitsLivingEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		sourceentity.setDeltaMovement(new Vec3(((entity.getX() - sourceentity.getX()) * 0.1), ((entity.getY() - sourceentity.getY()) * 0.1), ((entity.getZ() - sourceentity.getZ()) * 0.1)));
	}
}
