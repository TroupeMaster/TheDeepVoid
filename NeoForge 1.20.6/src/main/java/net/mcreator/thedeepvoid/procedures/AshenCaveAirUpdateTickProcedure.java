package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class AshenCaveAirUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
				if (Math.random() < 0.1) {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.DEEPSLATE_LAVA_GEYSER.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.COBBLED_DEEPSLATE.defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.ASH_BLOCK.get().defaultBlockState(), 3);
				}
				if (0.08 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ASHEN_VOID_FERN.get().defaultBlockState(), 3);
				} else if (0.5 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ASH_PILE.get().defaultBlockState(), 3);
				} else if (0.08 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.SMOKE_VENT.get().defaultBlockState(), 3);
				} else if (0.001 >= Math.random()) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.ASHEN_CAVE_AIR.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			} else if (0.2 >= Math.random() && Blocks.DEEPSLATE == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				if (Math.random() < 0.4) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.HANGING_MARROW.get().defaultBlockState(), 3);
				}
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
