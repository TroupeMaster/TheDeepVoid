package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class LightOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getLightEmission(world, BlockPos.containing(x, y - 1, z)) == 0) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
