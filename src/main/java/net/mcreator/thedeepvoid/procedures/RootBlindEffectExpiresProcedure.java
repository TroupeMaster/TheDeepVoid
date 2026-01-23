package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class RootBlindEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double yOffset = 0;
		double distance = 0;
		yOffset = 1.5;
		distance = 1;
		world.levelEvent(2001, BlockPos.containing(entity.getX() + entity.getLookAngle().x * distance, entity.getY() + yOffset, entity.getZ() + entity.getLookAngle().z * distance),
				Block.getId(TheDeepVoidModBlocks.INFESTED_ROTTEN_ROOTS.get().defaultBlockState()));
	}
}
