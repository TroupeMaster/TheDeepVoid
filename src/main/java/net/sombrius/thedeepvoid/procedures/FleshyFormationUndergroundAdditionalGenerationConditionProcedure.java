package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.HiveBrainEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

public class FleshyFormationUndergroundAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(HiveBrainEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
