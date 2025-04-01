package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class LickerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) Double.POSITIVE_INFINITY, 9, false, false));
		world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.LICKER_TONGUE.get()), x, (y + 0.4), z, 0, (-0.2), 0);
		world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.LICKER_TONGUE.get()), x, (y + 0.4), z, 0, (-0.4), 0);
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 35, 35, 35), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, (y - 10), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						entityiterator.setDeltaMovement(new Vec3(0, 0.5, 0));
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, (y - 5), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						entityiterator.setDeltaMovement(new Vec3(0, 0.5, 0));
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && entity.isVehicle() == false) {
						entityiterator.startRiding(entity);
					}
				}
			}
		}
	}
}
