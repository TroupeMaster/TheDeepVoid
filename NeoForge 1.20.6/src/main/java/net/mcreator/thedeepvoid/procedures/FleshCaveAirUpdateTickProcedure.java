package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class FleshCaveAirUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
				if (Math.random() < 0.1) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.1) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.EYE_FLESH_BLOCK.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
				}
				if (0.3 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.TENDRILS.get().defaultBlockState(), 3);
				} else if (0.2 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUS_FLOWER.get().defaultBlockState(), 3);
				} else if (0.1 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.TEETH.get().defaultBlockState(), 3);
				} else if (0.05 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUS_SACK.get().defaultBlockState(), 3);
				} else if (0.0015 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_CAVE_AIR.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			} else if (0.1 >= Math.random() && Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.EYE_VINE_STEM.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
