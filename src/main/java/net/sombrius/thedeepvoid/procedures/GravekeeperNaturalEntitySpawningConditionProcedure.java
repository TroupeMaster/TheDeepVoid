package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.GravekeeperEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

public class GravekeeperNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(GravekeeperEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty() == false) {
			return true;
		}
		return false;
	}
}
