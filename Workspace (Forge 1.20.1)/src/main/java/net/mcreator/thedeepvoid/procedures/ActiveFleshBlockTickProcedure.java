package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class ActiveFleshBlockTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (DeepVoidConfigConfiguration.STOPACTIVEBLOCKGENERATION.get() == true) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
			}
		}
		if (DeepVoidConfigConfiguration.STOPACTIVEBLOCKGENERATION.get() == false) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:flesh_plants"))))
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:flesh_plants"))))) {
				if (Math.random() < 0.2) {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
				}
			} else {
				if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
					if (Math.random() < 0.2) {
						world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.PEEPING_STEM.get().defaultBlockState(), 3);
						if (Math.random() < 0.2) {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
						}
					} else if (Math.random() < 0.4) {
						world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.TENDRILS.get().defaultBlockState(), 3);
						if (Math.random() < 0.2) {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
						}
					} else if (Math.random() < 0.2) {
						world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.PUS_FLOWER.get().defaultBlockState(), 3);
						if (Math.random() < 0.2) {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
						}
					} else if (Math.random() < 0.2) {
						world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.GORE_STEMS.get().defaultBlockState(), 3);
						if (Math.random() < 0.2) {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
						}
					} else if (Math.random() < 0.1) {
						world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.TEETH.get().defaultBlockState(), 3);
						if (Math.random() < 0.2) {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
						}
					}
				}
				if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
					if (Math.random() < 0.4) {
						world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.EYE_VINE_STEM.get().defaultBlockState(), 3);
					} else if (Math.random() < 0.4) {
						if (Math.random() < 0.5) {
							world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.TENDONS.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.EYE_TENDONS.get().defaultBlockState(), 3);
						}
						if (!world.getBlockState(BlockPos.containing(x, y - 2, z)).canOcclude()) {
							if (Math.random() < 0.5) {
								world.setBlock(BlockPos.containing(x, y - 2, z), TheDeepVoidModBlocks.TENDONS.get().defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(x, y - 2, z), TheDeepVoidModBlocks.EYE_TENDONS.get().defaultBlockState(), 3);
							}
							if (!world.getBlockState(BlockPos.containing(x, y - 3, z)).canOcclude()) {
								if (Math.random() < 0.5) {
									world.setBlock(BlockPos.containing(x, y - 3, z), TheDeepVoidModBlocks.TENDONS.get().defaultBlockState(), 3);
								} else {
									world.setBlock(BlockPos.containing(x, y - 3, z), TheDeepVoidModBlocks.EYE_TENDONS.get().defaultBlockState(), 3);
								}
								if (!world.getBlockState(BlockPos.containing(x, y - 4, z)).canOcclude()) {
									if (Math.random() < 0.5) {
										world.setBlock(BlockPos.containing(x, y - 4, z), TheDeepVoidModBlocks.TENDONS.get().defaultBlockState(), 3);
									} else {
										world.setBlock(BlockPos.containing(x, y - 4, z), TheDeepVoidModBlocks.EYE_TENDONS.get().defaultBlockState(), 3);
									}
									if (!world.getBlockState(BlockPos.containing(x, y - 5, z)).canOcclude()) {
										if (Math.random() < 0.5) {
											world.setBlock(BlockPos.containing(x, y - 5, z), TheDeepVoidModBlocks.TENDONS.get().defaultBlockState(), 3);
										} else {
											world.setBlock(BlockPos.containing(x, y - 5, z), TheDeepVoidModBlocks.EYE_TENDONS.get().defaultBlockState(), 3);
										}
									}
								}
							}
						}
					}
					if (Math.random() < 0.2) {
						world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get().defaultBlockState(), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
