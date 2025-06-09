package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class VoidGrowthNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.VOID_GROWTH.get()) && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}
