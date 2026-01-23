package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class FakeTorchOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.7), (z + 0.5), 0, 0, 0);
		world.addParticle(ParticleTypes.SMOKE, (x + 0.5), (y + 0.7), (z + 0.5), 0, 0.03, 0);
	}
}
