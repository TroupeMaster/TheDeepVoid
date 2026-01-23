package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class BloodBowPropertyValueProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDouble("bloodBowPulling") / 22;
	}
}
