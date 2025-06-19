package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class VoidCaveAirUpdatesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
				if (Math.random() < 0.2) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.LIQUID_VOID.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.ANCIENT_DEEPSLATE.get().defaultBlockState(), 3);
				}
				if (0.3 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.VOID_ROSE.get().defaultBlockState(), 3);
				} else if (0.2 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.VOID_FERN.get().defaultBlockState(), 3);
				} else if (0.0015 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.VOID_CAVE_AIR.get().defaultBlockState(), 3);
				}
			} else if (0.1 >= Math.random() && Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.VOID_ROOTS.get().defaultBlockState(), 3);
			}
		}
	}
}
