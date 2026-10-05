package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.MimicEntity;
import net.sombrius.thedeepvoid.entity.FalseHydraSingingEntity;
import net.sombrius.thedeepvoid.entity.FalseHydraEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;

public class MimicNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(MimicEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty()) && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(FalseHydraSingingEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty()) && Math.random() < 0.7) {
			return true;
		}
		return false;
	}
}
