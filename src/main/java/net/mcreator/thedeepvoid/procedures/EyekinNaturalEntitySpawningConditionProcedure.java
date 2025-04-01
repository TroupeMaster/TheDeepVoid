package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thedeepvoid.entity.EyekinFlyingEntity;
import net.mcreator.thedeepvoid.entity.EyekinEntity;

public class EyekinNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(EyekinEntity.class, AABB.ofSize(new Vec3(x, y, z), 140, 140, 140), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(EyekinFlyingEntity.class, AABB.ofSize(new Vec3(x, y, z), 140, 140, 140), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
