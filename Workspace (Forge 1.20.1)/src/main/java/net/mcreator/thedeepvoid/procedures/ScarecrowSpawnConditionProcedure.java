package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thedeepvoid.entity.ScarecrowEntity;

public class ScarecrowSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(ScarecrowEntity.class, AABB.ofSize(new Vec3(x, y, z), 120, 120, 120), e -> true).isEmpty() == false && y > 45) {
			return true;
		}
		return false;
	}
}
