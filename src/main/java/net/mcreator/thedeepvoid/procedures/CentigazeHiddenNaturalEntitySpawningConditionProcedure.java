package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.CentigazeHiddenEntity;

public class CentigazeHiddenNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(CentigazeHiddenEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty() == false && y <= 40
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.DESOLATE_SOIL.get()) {
			return true;
		}
		return false;
	}
}
