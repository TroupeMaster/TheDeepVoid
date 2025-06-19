package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SulfurOreBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.LAVA) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.LAVA)
				&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.LAVA) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.LAVA)
				&& !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.LAVA) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.LAVA)) {
			return true;
		}
		return false;
	}
}
