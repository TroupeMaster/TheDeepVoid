package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class SoulSlashWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double repeat = 0;
		double randomXX = 0;
		double randomYY = 0;
		double randomZZ = 0;
		double X = 0;
		double Y = 0;
		double Z = 0;
		immediatesourceentity.setNoGravity(true);
		{
			final Vec3 _center = new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), (float) (double) DeepVoidConfigConfiguration.THEHARVESTSLASH.get());
				}
			}
		}
		repeat = 0;
		randomXX = Mth.nextInt(RandomSource.create(), -10, 10);
		randomYY = Mth.nextInt(RandomSource.create(), -1, 1);
		randomZZ = Mth.nextInt(RandomSource.create(), -10, 10);
		for (int index0 = 0; index0 < 12; index0++) {
			repeat = repeat + 1;
			X = immediatesourceentity.getX() - (immediatesourceentity.getX() - (immediatesourceentity.getX() + randomXX)) * (repeat / 8);
			Y = (immediatesourceentity.getY() + 0.8) - ((immediatesourceentity.getY() + 0.8) - (immediatesourceentity.getY() + randomYY)) * (repeat / 8);
			Z = immediatesourceentity.getZ() - (immediatesourceentity.getZ() - (immediatesourceentity.getZ() + randomZZ)) * (repeat / 8);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, X, Y, Z, 4, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SCULK_SOUL, X, Y, Z, 4, 0.1, 0.1, 0.1, 0);
		}
		TheDeepVoidMod.queueServerWork(80, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}
