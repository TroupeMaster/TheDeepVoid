package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.EyekinFlyingEntity;

import java.util.List;
import java.util.Comparator;

public class EyekinOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			if (entity.getPersistentData().getDouble("deep_void:flyingChance") >= 240) {
				entity.getPersistentData().putDouble("deep_void:flyingChance", 0);
				if (Math.random() < 0.1) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.EYEKIN_FLYING.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					{
						final Vec3 _center = new Vec3(x, (y + 1), z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof EyekinFlyingEntity) {
								if (entityiterator instanceof LivingEntity _entity)
									_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
								entityiterator.setDeltaMovement(new Vec3(0, 0.4, 0));
							}
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
			} else {
				entity.getPersistentData().putDouble("deep_void:flyingChance", (entity.getPersistentData().getDouble("deep_void:flyingChance") + 1));
			}
		}
	}
}
