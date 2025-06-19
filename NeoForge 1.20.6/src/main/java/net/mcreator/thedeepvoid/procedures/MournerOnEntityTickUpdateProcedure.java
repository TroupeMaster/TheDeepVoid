package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.List;
import java.util.Comparator;

public class MournerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.DEAD_INSIDE, 160, 0));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 160, 0));
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 0) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
		if (entity.getDeltaMovement().x() > 0 || entity.getDeltaMovement().z() > 0) {
			if (Math.random() < 0.07) {
				world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), (x + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) + entity.getLookAngle().x * 0.5), (y + 2.6),
						(z + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) + entity.getLookAngle().z * 0.5), 0, 0.2, 0);
			}
			if (Math.random() < 0.07) {
				world.addParticle((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), (x + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) + entity.getLookAngle().x * 0.5), (y + 2.6),
						(z + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) + entity.getLookAngle().z * 0.5), 0, 0.2, 0);
			}
		}
	}
}
