package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class VoidDwellerSpawningProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (y <= 30 && ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get())) {
			return true;
		}
		return false;
	}
}
