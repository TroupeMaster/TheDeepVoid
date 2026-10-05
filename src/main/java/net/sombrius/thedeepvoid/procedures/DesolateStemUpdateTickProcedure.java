package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DesolateStemUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.8 && world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			if (Math.random() < 0.8) {
				if (Math.random() < 0.4) {
					world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.LIVING_GLOOM_STEM.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
				}
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			}
		}
	}
}
