package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.ShadowHandEntity;
import net.mcreator.thedeepvoid.entity.SeekerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HandSpawnOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(!world.getEntitiesOfClass(ShadowHandEntity.class, AABB.ofSize(new Vec3(x, (y + 0.5), z), 0.5, 0.5, 0.5), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(SeekerEntity.class, AABB.ofSize(new Vec3(x, (y + 0.5), z), 0.5, 0.5, 0.5), e -> true).isEmpty())) {
			if (entity.getPersistentData().getBoolean("deep_void:randomDone") == false) {
				if (Math.random() < 0.08) {
					entity.getPersistentData().putBoolean("deep_void:randomDone", true);
					TheDeepVoidMod.queueServerWork(60, () -> {
						if (!(!world.getEntitiesOfClass(SeekerEntity.class, AABB.ofSize(new Vec3(x, (y + 0.5), z), 0.5, 0.5, 0.5), e -> true).isEmpty())) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.SEEKER.get().spawn(_level, BlockPos.containing(x, y + 0.5, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							if (!entity.level().isClientSide())
								entity.discard();
						}
					});
				} else {
					entity.getPersistentData().putBoolean("deep_void:randomDone", true);
					TheDeepVoidMod.queueServerWork(60, () -> {
						if (!(!world.getEntitiesOfClass(ShadowHandEntity.class, AABB.ofSize(new Vec3(x, (y + 0.5), z), 0.5, 0.5, 0.5), e -> true).isEmpty())) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = TheDeepVoidModEntities.SHADOW_HAND.get().spawn(_level, BlockPos.containing(x, y + 0.5, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							{
								final Vec3 _center = new Vec3(x, (y + 0.5), z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof ShadowHandEntity) {
										if (entityiterator instanceof ShadowHandEntity) {
											((ShadowHandEntity) entityiterator).setAnimation("animation.shadowHand_exit");
										}
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 99, false, false));
									}
								}
							}
							if (!entity.level().isClientSide())
								entity.discard();
						}
					});
				}
			}
		}
	}
}
