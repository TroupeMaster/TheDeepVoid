package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DesolateCaveAirUpdatesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double zs = 0;
		double ys = 0;
		double xs = 0;
		if (y <= 40) {
			zs = -32;
			for (int index0 = 0; index0 < 64; index0++) {
				xs = -32;
				for (int index1 = 0; index1 < 64; index1++) {
					ys = -8;
					for (int index2 = 0; index2 < 16; index2++) {
						ys = ys + 1;
						DesolateCaveAirUpdateTickProcedure.execute(world, x + xs, y + ys, z + zs);
					}
					xs = xs + 1;
				}
				zs = zs + 1;
			}
		}
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
	}
}
