package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.WatchingStalkerEntity;
import net.sombrius.thedeepvoid.entity.MimicEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class StalkingStalkerNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:misted_remnants"))) {
			if (!(!world.getEntitiesOfClass(WatchingStalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())
					&& !(!world.getEntitiesOfClass(MimicEntity.class, AABB.ofSize(new Vec3(x, y, z), 250, 250, 250), e -> true).isEmpty())) {
				return true;
			}
		} else {
			if (!(!world.getEntitiesOfClass(WatchingStalkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				return true;
			}
		}
		return false;
	}
}
