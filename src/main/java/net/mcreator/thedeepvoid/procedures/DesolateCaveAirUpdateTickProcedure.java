package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class DesolateCaveAirUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
				if (0.008 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.GRIM_SOIL.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.DESOLATE_SOIL.get().defaultBlockState(), 3);
				}
				if (0.08 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
				} else if (0.2 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
				} else if (0.0015 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_CAVE_AIR.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			} else if (0.2 >= Math.random() && Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.DESOLATE_SOIL.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_GROWTH.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
