package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thedeepvoid.entity.FoolEaterEntity;

public class FoolEaterNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(FoolEaterEntity.class, AABB.ofSize(new Vec3(x, y, z), 245, 245, 245), e -> true).isEmpty() == false) {
			return true;
		}
		return false;
	}
}
