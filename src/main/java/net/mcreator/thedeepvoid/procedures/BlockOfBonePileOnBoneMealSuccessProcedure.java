package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class BlockOfBonePileOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
			if (Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.ROTTEN_GRASS.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
			}
		}
	}
}
