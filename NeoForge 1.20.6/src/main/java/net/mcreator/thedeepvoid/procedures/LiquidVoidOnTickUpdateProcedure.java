package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

public class LiquidVoidOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
			if (Math.random() < 0.01) {
				world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.BLACK_TENTACLE.get()), (x + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (y + 1), (z + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0, 0, 0);
			}
		}
	}
}
