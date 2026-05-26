package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class DesolateSoilBoneMealedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get())) {
			if (Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.OVERGROWN_GLOOM_GROWTH.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y - 1, z), TheDeepVoidModBlocks.DESOLATE_GROWTH.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get())) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 1, z)) && ((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 2, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 2, y + 1, z), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x + 2, y + 1, z), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z)) && ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z)) && ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 1, z)) && ((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 2, y + 1, z), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 2, y + 1, z), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x - 2, y + 1, z), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 2)) && ((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z + 2), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z + 2), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z + 2), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1)) && ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z + 1), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z + 1), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z + 1), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 1)) && ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z - 1), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z - 1), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z - 1), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 2)) && ((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z - 2), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x, y + 1, z - 2), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + 1, z - 2), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z + 1)) && ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z + 1)) && ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z - 1)) && ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z - 1)) && ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL_ACTIVE.get()) && Math.random() < 0.4) {
			if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), TheDeepVoidModBlocks.DESOLATE_STEM.get().defaultBlockState(), 3);
			} else if (Math.random() < 0.2) {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), TheDeepVoidModBlocks.OVERGROWN_VOIDLIGHT.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), TheDeepVoidModBlocks.DESOLATE_LICHEN.get().defaultBlockState(), 3);
			}
		}
	}
}
