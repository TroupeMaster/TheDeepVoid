package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ScarecrowEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

public class ScarecrowSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(ScarecrowEntity.class, AABB.ofSize(new Vec3(x, y, z), 120, 120, 120), e -> true).isEmpty() == false && y > 45) {
			return true;
		}
		return false;
	}
}
