package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class DesolateStemUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() == false && ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_STEM.get()) == false) {
			if (Math.random() < 0.8) {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.VOIDLIGHT.get().defaultBlockState(), 3);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() == false && ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_STEM.get()) == false) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}
