package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thedeepvoid.entity.ThumperEntityEntity;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class FleshWormNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (y >= 45 && !(!world.getEntitiesOfClass(FleshWormEntity.class, AABB.ofSize(new Vec3(x, y, z), 150, 150, 150), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(ThumperEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 250, 250, 250), e -> true).isEmpty()) && Math.random() < (double) DeepVoidConfigConfiguration.FLESHWORMSPAWNCHANCE.get()) {
			return true;
		}
		return false;
	}
}
