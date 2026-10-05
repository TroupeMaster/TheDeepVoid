package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VoidGrowthNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.VOID_GROWTH.get()) && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}
