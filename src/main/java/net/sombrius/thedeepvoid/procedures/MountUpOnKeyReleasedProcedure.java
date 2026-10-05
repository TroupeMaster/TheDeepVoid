package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.RideableFlyingEyekinEntity;

import net.minecraft.world.entity.Entity;

public class MountUpOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof RideableFlyingEyekinEntity) {
			(entity.getVehicle()).getPersistentData().putDouble("verticalMovement", 0);
		}
	}
}
