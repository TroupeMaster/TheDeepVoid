package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

public class MotherBoneCrawlerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getPersistentData().getDouble("deep_void:eggMax") >= 3)) {
			if (entity.getPersistentData().getDouble("deep_void:lay_egg") >= 400) {
				entity.getPersistentData().putDouble("deep_void:lay_egg", 0);
				if (Math.random() < 0.4) {
					if (!world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
						entity.getPersistentData().putDouble("deep_void:eggMax", (entity.getPersistentData().getDouble("deep_void:eggMax") + 1));
						world.setBlock(BlockPos.containing(x, y, z), TheDeepVoidModBlocks.BONE_CRAWLER_EGG.get().defaultBlockState(), 3);
					}
				}
			} else {
				entity.getPersistentData().putDouble("deep_void:lay_egg", (entity.getPersistentData().getDouble("deep_void:lay_egg") + 1));
			}
		}
	}
}
