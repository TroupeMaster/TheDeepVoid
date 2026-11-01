package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ApostleBossEntity;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.Comparator;

public class ApostleCheckForStompProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ApostleBossEntity _datEntL0 && _datEntL0.getEntityData().get(ApostleBossEntity.DATA_doingAttack)) == false
				&& (entity instanceof ApostleBossEntity _datEntL1 && _datEntL1.getEntityData().get(ApostleBossEntity.DATA_jumpGrab)) == false && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
				&& entity.getPersistentData().getDouble("stompCooldown") <= 0) {
			if (entity.getPersistentData().getDouble("checkForStomp") >= 10 && Math.random() < 0.1) {
				entity.getPersistentData().putDouble("checkForStomp", 0);
				entity.getPersistentData().putDouble("stompCooldown",
						((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / (double) DeepVoidConfigConfiguration.APOSTLESECONDPHASE.get() ? 100 : 200));
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
							ApostleStompProcedure.execute(world, x, y, z, entity);
							break;
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("checkForStomp", (entity.getPersistentData().getDouble("checkForStomp") + 1));
			}
		} else if (entity.getPersistentData().getDouble("stompCooldown") > 0) {
			entity.getPersistentData().putDouble("stompCooldown", (entity.getPersistentData().getDouble("stompCooldown") - 1));
		}
	}
}
