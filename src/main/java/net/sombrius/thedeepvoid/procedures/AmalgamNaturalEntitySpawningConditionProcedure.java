package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.AmalgamEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

public class AmalgamNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (y < 30 && !world.getEntitiesOfClass(AmalgamEntity.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty() == false) {
			return true;
		}
		return false;
	}
}
