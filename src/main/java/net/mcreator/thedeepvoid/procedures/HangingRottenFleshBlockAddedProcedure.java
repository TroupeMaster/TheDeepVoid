package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class HangingRottenFleshBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}
