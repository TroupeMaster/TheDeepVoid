package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.DarkSteelFlailEntity;

import java.util.List;
import java.util.Comparator;

public class DarkSteelFlailSolidBoundingBoxConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean solid = false;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if ((entity instanceof DarkSteelFlailEntity _datEntL1 && _datEntL1.getEntityData().get(DarkSteelFlailEntity.DATA_retract)) == true
					|| (entity instanceof DarkSteelFlailEntity _datEntL2 && _datEntL2.getEntityData().get(DarkSteelFlailEntity.DATA_hit)) == true) {
				return false;
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
							solid = true;
						}
					}
				}
				if (solid == true) {
					return false;
				}
			}
		}
		return true;
	}
}
