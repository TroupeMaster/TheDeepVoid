package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.VoidbornTentaclesEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;

public class VoidbornTentaclesOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 1, 1, 1), e -> true).isEmpty()) {
			if (entity instanceof VoidbornTentaclesEntity) {
				((VoidbornTentaclesEntity) entity).setAnimation("animation.voidbornTentacles_spawn");
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
