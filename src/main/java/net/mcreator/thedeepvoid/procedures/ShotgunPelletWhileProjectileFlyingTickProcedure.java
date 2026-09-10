package net.mcreator.thedeepvoid.procedures;

import org.joml.Vector3f;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.DustParticleOptions;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ShotgunPelletWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
			world.addParticle((new DustParticleOptions(new Vector3f(78 / 255.0F, 9 / 255.0F, 9 / 255.0F), 1)), (x + Mth.nextDouble(RandomSource.create(), -0.06, 0.06)), y, (z + Mth.nextDouble(RandomSource.create(), -0.06, 0.06)), 0, 0, 0);
		}
		if (!immediatesourceentity.isNoGravity()) {
			immediatesourceentity.setNoGravity(true);
		}
		TheDeepVoidMod.queueServerWork(8, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}
