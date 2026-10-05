package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.EyekinFlyingEntity;
import net.sombrius.thedeepvoid.entity.EyekinEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

public class EyekinNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(EyekinEntity.class, AABB.ofSize(new Vec3(x, y, z), 140, 140, 140), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(EyekinFlyingEntity.class, AABB.ofSize(new Vec3(x, y, z), 140, 140, 140), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
