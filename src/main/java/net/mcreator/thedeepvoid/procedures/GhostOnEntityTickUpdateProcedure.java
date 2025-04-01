package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.thedeepvoid.entity.CathedralGhostEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.Comparator;

public class GhostOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(CathedralGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).isEmpty()) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(CathedralGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(CathedralGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(CathedralGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 24, 24, 24), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1);
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (!world.getEntitiesOfClass(CathedralGhostEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		TheDeepVoidMod.queueServerWork(200, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 0, 0, 0);
	}
}
