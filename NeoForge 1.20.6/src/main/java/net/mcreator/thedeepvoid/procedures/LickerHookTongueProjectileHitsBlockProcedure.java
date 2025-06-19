package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class LickerHookTongueProjectileHitsBlockProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(((x - entity.getX()) * 0.1), ((y - entity.getY()) * 0.1), ((z - entity.getZ()) * 0.1)));
	}
}
