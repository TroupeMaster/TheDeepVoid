package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class DesolateSoilActiveOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_GROWTH.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_STEM.get() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_LICHEN.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == TheDeepVoidModBlocks.BLOSSOMING_DESOLATE_LICHEN.get()) {
			world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_SOIL.get().defaultBlockState(), 3);
		} else {
			if (Math.random() < 0.3) {
				if (!((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_STEM.get())
						&& !((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_STEM.get())
						&& !((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_STEM.get())
						&& !((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_STEM.get()) && !world.getBlockState(BlockPos.containing(x + 1, y + 1, z)).canOcclude()
						&& !world.getBlockState(BlockPos.containing(x - 1, y + 1, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z - 1)).canOcclude()
						&& !world.getBlockState(BlockPos.containing(x, y + 1, z + 1)).canOcclude()) {
					world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_SOIL.get().defaultBlockState(), 3);
					if (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude()) {
						world.setBlock(BlockPos.containing(x, y + 2, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
						if (!world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude()) {
							if (Math.random() < 0.6) {
								world.setBlock(BlockPos.containing(x, y + 3, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
								if (!world.getBlockState(BlockPos.containing(x, y + 4, z)).canOcclude()) {
									if (Math.random() < 0.5) {
										world.setBlock(BlockPos.containing(x, y + 4, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
										if (!world.getBlockState(BlockPos.containing(x, y + 5, z)).canOcclude()) {
											if (Math.random() < 0.4) {
												world.setBlock(BlockPos.containing(x, y + 5, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
												if (!world.getBlockState(BlockPos.containing(x, y + 6, z)).canOcclude()) {
													world.setBlock(BlockPos.containing(x, y + 6, z), TheDeepVoidModBlocks.VOIDLIGHT.get().defaultBlockState(), 3);
												}
											} else {
												world.setBlock(BlockPos.containing(x, y + 5, z), TheDeepVoidModBlocks.VOIDLIGHT.get().defaultBlockState(), 3);
											}
										}
									} else {
										world.setBlock(BlockPos.containing(x, y + 4, z), TheDeepVoidModBlocks.VOIDLIGHT.get().defaultBlockState(), 3);
									}
								}
							} else {
								world.setBlock(BlockPos.containing(x, y + 3, z), TheDeepVoidModBlocks.VOIDLIGHT.get().defaultBlockState(), 3);
							}
						}
					}
				}
			} else if (Math.random() < 0.4) {
				if (Math.random() < 0.1) {
					world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.BLOSSOMING_DESOLATE_LICHEN.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_SOIL.get().defaultBlockState(), 3);
				} else if (Math.random() < 0.4) {
					world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.DESOLATE_SOIL.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
