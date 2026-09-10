package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.FlailExecutionerEntity;

import java.util.List;
import java.util.Comparator;

public class ExecutionerDarkSteelFlailEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof FlailExecutionerEntity) {
					if (entityiterator instanceof FlailExecutionerEntity _datEntSetL)
						_datEntSetL.getEntityData().set(FlailExecutionerEntity.DATA_flailThrow, false);
				}
			}
		}
	}
}
