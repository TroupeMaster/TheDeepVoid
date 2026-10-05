package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ManiacEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

public class ManiacNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(ManiacEntity.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) && y > 45 && Math.random() < 0.15) {
			return true;
		}
		return false;
	}
}
