package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class HuntersBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getBoolean("doubleJump") == true) {
			if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR)) {
				itemstack.getOrCreateTag().putBoolean("doubleJump", false);
			}
		}
	}
}
