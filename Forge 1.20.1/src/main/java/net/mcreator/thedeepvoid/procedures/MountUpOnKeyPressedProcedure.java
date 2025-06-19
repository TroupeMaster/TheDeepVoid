package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.RideableFlyingEyekinEntity;

public class MountUpOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof RideableFlyingEyekinEntity) {
			(entity.getVehicle()).getPersistentData().putDouble("verticalMovement", 1);
		}
	}
}
