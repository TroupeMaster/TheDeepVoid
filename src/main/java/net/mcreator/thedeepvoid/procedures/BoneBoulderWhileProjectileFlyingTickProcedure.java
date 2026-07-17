package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class BoneBoulderWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.1) {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_SKULL_PILE.get().defaultBlockState()));
		}
	}
}
