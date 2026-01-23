package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HiveWatcherIchorPillarProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2,
						(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2,
						(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
			}
		}
		entity.getPersistentData().putDouble("ichorX", (entity.getX()));
		entity.getPersistentData().putDouble("ichorY", (entity.getY()));
		entity.getPersistentData().putDouble("ichorZ", (entity.getZ()));
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("ichorX") + 2, entity.getPersistentData().getDouble("ichorY"), entity.getPersistentData().getDouble("ichorZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound((entity.getPersistentData().getDouble("ichorX") + 2), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX") + 2), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ")), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX") + 2), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX") - 2), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ")), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX") - 2), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ") + 2), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ") + 2));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ") - 2), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ") - 2));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(40, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("ichorX") + 4, entity.getPersistentData().getDouble("ichorY"), entity.getPersistentData().getDouble("ichorZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound((entity.getPersistentData().getDouble("ichorX") + 4), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX") + 4), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ")), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX") + 4), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX") - 4), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ")), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX") - 4), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ") + 4), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ") + 4));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ") - 4), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ") - 4));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(60, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("ichorX") + 6, entity.getPersistentData().getDouble("ichorY"), entity.getPersistentData().getDouble("ichorZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound((entity.getPersistentData().getDouble("ichorX") + 6), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX") + 6), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ")), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX") + 6), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX") - 6), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ")), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX") - 6), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ") + 6), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ") + 6));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.ICHOR_FLAME.get()), (entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY") + 0.5),
						(entity.getPersistentData().getDouble("ichorZ") - 6), 9, 0.01, 3, 0.01, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("ichorX")), (entity.getPersistentData().getDouble("ichorY")), (entity.getPersistentData().getDouble("ichorZ") - 6));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 60, 0));
					}
				}
			}
		});
	}
}
