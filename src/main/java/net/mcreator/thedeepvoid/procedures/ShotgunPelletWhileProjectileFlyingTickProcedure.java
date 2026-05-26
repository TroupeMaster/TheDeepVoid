package net.mcreator.thedeepvoid.procedures;

import org.joml.Vector3f;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.DustParticleOptions;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class ShotgunPelletWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		world.addParticle((new DustParticleOptions(new Vector3f(73 / 255.0F, 73 / 255.0F, 73 / 255.0F), 1)), x, y, z, 0, 0, 0);
		if (!immediatesourceentity.isNoGravity()) {
			immediatesourceentity.setNoGravity(true);
		}
		TheDeepVoidMod.queueServerWork(8, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}
