package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class BoneCaveAirUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.MOSSY_BONE_PILE.get().defaultBlockState(), 3);
				if (0.1 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.CAVE_GROWTH.get().defaultBlockState(), 3);
				} else if (0.2 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
				} else if (0.001 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BONE_CAVE_AIR.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			} else if (0.2 >= Math.random() && Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				if (Math.random() < 0.4) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.CONNECTED_MARROW.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.HANGING_MARROW.get().defaultBlockState(), 3);
				}
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
