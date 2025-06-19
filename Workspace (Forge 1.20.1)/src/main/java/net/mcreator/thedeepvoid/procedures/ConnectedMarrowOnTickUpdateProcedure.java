package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class ConnectedMarrowOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.CONNECTED_MARROW.get())) {
			if (Math.random() < 0.7) {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.CONNECTED_MARROW.get().defaultBlockState(), 3);
			}
		}
	}
}
