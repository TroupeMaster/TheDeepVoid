package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class RottenMossActiveOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) {
			if (Math.random() < 0.6) {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ROTTEN_MOSS.get().defaultBlockState(), 3);
				if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.HANGING_MARROW.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.CONNECTED_MARROW.get().defaultBlockState(), 3);
				}
			} else {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ROTTEN_MOSS.get().defaultBlockState(), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
			if (Math.random() < 0.6) {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ROTTEN_MOSS.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ROTTEN_MOSS.get().defaultBlockState(), 3);
			}
		} else {
			world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ROTTEN_MOSS.get().defaultBlockState(), 3);
		}
	}
}
