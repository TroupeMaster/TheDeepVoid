package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class AmbrosiaCloudOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		if (entity.getPersistentData().getDouble("despawn") >= 100) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("despawn", (entity.getPersistentData().getDouble("despawn") + 1));
		}
		loop = 0;
		particleAmount = 6;
		xRadius = 0;
		zRadius = 0;
		while (xRadius < 2 && zRadius < 2) {
			while (loop < particleAmount) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (x + Math.cos(((Math.PI * 2) / particleAmount) * loop) * (xRadius + Mth.nextDouble(RandomSource.create(), -0.5, 0.5))), (y + 0.1),
							(z + Math.sin(((Math.PI * 2) / particleAmount) * loop) * (zRadius + Mth.nextDouble(RandomSource.create(), -0.5, 0.5))), 1, 0, 0, 0, 0.01);
				loop = loop + 1;
			}
			loop = 0;
			particleAmount = 6;
			xRadius = xRadius + 1;
			zRadius = zRadius + 1;
		}
	}
}
