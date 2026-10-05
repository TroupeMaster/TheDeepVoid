package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.SleepingPrimordialCrawlerEntity;
import net.sombrius.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.sombrius.thedeepvoid.entity.MotherBoneCrawlerEntity;
import net.sombrius.thedeepvoid.entity.BlackFlyEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

public class BlackFlyNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (y >= 45 && !(!world.getEntitiesOfClass(SleepingPrimordialCrawlerEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(PrimordialBoneCrawlerEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(MotherBoneCrawlerEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(BlackFlyEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
