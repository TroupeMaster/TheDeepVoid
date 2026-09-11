package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class AbyssalMarkOnEffectActiveTickProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("abyssalMarkLevel") != amplifier) {
			entity.getPersistentData().putDouble("abyssalMarkLevel", amplifier);
		}
	}
}
