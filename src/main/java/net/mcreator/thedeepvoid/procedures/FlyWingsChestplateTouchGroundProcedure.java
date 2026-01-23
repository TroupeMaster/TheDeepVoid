package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class FlyWingsChestplateTouchGroundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("flyWingsTouchGround") == false && world.getBlockState(BlockPos.containing(x, y - 0.5, z)).canOcclude()) {
			entity.getPersistentData().putBoolean("flyWingsTouchGround", true);
		}
	}
}
