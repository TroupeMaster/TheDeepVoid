package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class FlareWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 3, (Mth.nextDouble(RandomSource.create(), -0.025, 0.025)), (-0.5), (Mth.nextDouble(RandomSource.create(), -0.025, 0.025)), 0.1);
		world.addParticle(ParticleTypes.FLASH, x, y, z, 0, (-0.1), 0);
		world.addParticle(ParticleTypes.END_ROD, x, y, z, 0, (-0.1), 0);
		TheDeepVoidMod.queueServerWork(48, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = TheDeepVoidModEntities.BIG_LIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
	}
}
