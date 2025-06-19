package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

public class SulfurTntEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("tick") == 15) {
			entity.getPersistentData().putDouble("tick", 0);
		} else {
			entity.getPersistentData().putDouble("tick", (entity.getPersistentData().getDouble("tick") + 1));
		}
		world.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0.1, 0);
		world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 0, 0.1, 0);
	}
}
