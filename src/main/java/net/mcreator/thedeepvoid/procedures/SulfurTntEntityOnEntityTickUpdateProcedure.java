package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;

import java.util.List;
import java.util.Comparator;

public class SulfurTntEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((x + 1), y, z));
		if (entity instanceof SulfurTntEntityEntity _datEntSetI)
			_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_explode, (int) ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_explode) : 0) + 1));
		if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_tick) : 0) == 15) {
			if (entity instanceof SulfurTntEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_tick, 0);
		} else {
			if (entity instanceof SulfurTntEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_tick, (int) ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_tick) : 0) + 1));
		}
		if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_explode) : 0) == 75) {
			if (entity instanceof SulfurTntEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_fuse, 1);
		} else if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_explode) : 0) == 76) {
			if (entity instanceof SulfurTntEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_fuse, (int) 1.2);
		} else if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_explode) : 0) == 77) {
			if (entity instanceof SulfurTntEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_fuse, (int) 1.4);
		} else if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_explode) : 0) == 78) {
			if (entity instanceof SulfurTntEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_fuse, (int) 1.6);
		} else if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_explode) : 0) == 79) {
			if (entity instanceof SulfurTntEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SulfurTntEntityEntity.DATA_fuse, (int) 1.8);
		}
		if ((entity instanceof SulfurTntEntityEntity _datEntI ? _datEntI.getEntityData().get(SulfurTntEntityEntity.DATA_explode) : 0) == 80) {
			if (!world.getEntitiesOfClass(SulfurTntEntityEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 2, 2, 2), e -> true).isEmpty()) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 12, Level.ExplosionInteraction.TNT);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !(entityiterator instanceof SulfurTntEntityEntity)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 260, 1));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 260, 1));
						}
					}
				}
			}
		}
		world.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0.1, 0);
		world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 0, 0.1, 0);
	}
}
