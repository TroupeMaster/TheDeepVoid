package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class BlockOfBonePileOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block")))) {
			world.setBlock(BlockPos.containing(x, y + 1, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 1, z)) && (world.getBlockState(BlockPos.containing(x + 2, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x + 2, y + 1, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z)) && (world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x + 1, y + 1, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z)) && (world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x - 1, y + 1, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 1, z)) && (world.getBlockState(BlockPos.containing(x - 2, y, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x - 2, y + 1, z), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 2)) && (world.getBlockState(BlockPos.containing(x, y, z + 2))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x, y + 1, z + 2), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1)) && (world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x, y + 1, z + 1), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 1)) && (world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x, y + 1, z - 1), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 2)) && (world.getBlockState(BlockPos.containing(x, y, z - 2))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x, y + 1, z - 2), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z + 1)) && (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z + 1)) && (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z - 1)) && (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z - 1)) && (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("the_deep_void:natural_bone_block"))) && Math.random() < 0.4) {
			world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), TheDeepVoidModBlocks.BONE_MARROW.get().defaultBlockState(), 3);
		}
	}
}
