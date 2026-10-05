package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.HiveWatcherEntity;
import net.sombrius.thedeepvoid.entity.AmbrosiaSpitEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class WatcherBlockadeSolidBoundingBoxConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (!(!world.getEntitiesOfClass(HiveWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && !(!world.getEntitiesOfClass(AmbrosiaSpitEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty())
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			return true;
		}
		return false;
	}
}
