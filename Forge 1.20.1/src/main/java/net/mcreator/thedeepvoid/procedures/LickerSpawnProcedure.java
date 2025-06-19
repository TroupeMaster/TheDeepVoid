package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class LickerSpawnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:staring_hills"))) && y < 30
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.ANCIENT_DEEPSLATE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE)) {
			return true;
		} else if (y < 30 && ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.FLESH_BLOCK.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.FLESH_BLOCK.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get())) {
			return true;
		}
		return false;
	}
}
