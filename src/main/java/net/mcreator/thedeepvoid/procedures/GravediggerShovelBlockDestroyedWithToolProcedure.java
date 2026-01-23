package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class GravediggerShovelBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x - 2, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.WALL_CORPSE.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.CORPSE_SPAWN_GRAVEYARD.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES_BLOCK.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == TheDeepVoidModBlocks.PILE_OF_BONES.get()) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), null);
					world.destroyBlock(_pos, false);
				}
			}
		}
	}
}
