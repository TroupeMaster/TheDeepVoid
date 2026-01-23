package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class VoidBlossomOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.33) {
			world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.VOID_ROSE.get().defaultBlockState(), 3);
		} else if (Math.random() < 0.33) {
			world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.VOID_FERN.get().defaultBlockState(), 3);
		} else if (Math.random() < 0.33) {
			world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.VOID_STEM.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.VOID_FERN.get().defaultBlockState(), 3);
		}
	}
}
