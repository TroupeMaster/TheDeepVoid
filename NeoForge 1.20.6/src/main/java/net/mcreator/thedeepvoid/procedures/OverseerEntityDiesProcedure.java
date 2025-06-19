package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

public class OverseerEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < 4; index0++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DEEPSLATE_PEBBLE.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 0.4)), (y + Mth.nextDouble(RandomSource.create(), 1, 3)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 0.4)), 2, 0, (-0.1), 0, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 0.4)), (y + Mth.nextDouble(RandomSource.create(), 1, 3)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 0.4)), 2, 0, (-0.1), 0, 0.1);
		}
	}
}
