package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.List;
import java.util.Comparator;

public class SkullSmasherEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof MisanthropicHivemindEntity) {
					if (entityiterator instanceof MisanthropicHivemindEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_skullSmasherCooldown, (int) (double) DeepVoidConfigConfiguration.SMASHERCOOLDOWN.get());
				}
			}
		}
	}
}
