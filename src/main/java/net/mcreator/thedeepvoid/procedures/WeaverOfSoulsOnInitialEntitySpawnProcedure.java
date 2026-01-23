package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class WeaverOfSoulsOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).getBlock() == TheDeepVoidModBlocks.SOUL_CONTAINER.get()) {
			world.setBlock(BlockPos.containing(entity.getX() + 23, entity.getY(), entity.getZ()), Blocks.IRON_BARS.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(entity.getX() + 23, entity.getY() - 1, entity.getZ()), Blocks.IRON_BARS.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(entity.getX() - 23, entity.getY(), entity.getZ()), Blocks.IRON_BARS.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(entity.getX() - 23, entity.getY() - 1, entity.getZ()), Blocks.IRON_BARS.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 23), Blocks.IRON_BARS.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ() + 23), Blocks.IRON_BARS.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 23), Blocks.IRON_BARS.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ() - 23), Blocks.IRON_BARS.defaultBlockState(), 3);
		}
	}
}
