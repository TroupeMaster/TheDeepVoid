package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class SmokeVentOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.SMOKE_VENT.get())) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 1), z, 5, 0, 0.1, 0, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 1), z, 5, 0, 0.1, 0, 0.1);
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LAVA, x, (y + 1), z, 2, 0, 0.1, 0, 0.1);
			}
		}
	}
}
