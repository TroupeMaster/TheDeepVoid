package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class FleshWormSpikesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FleshWormEntity _datEntSetL)
			_datEntSetL.getEntityData().set(FleshWormEntity.DATA_attacking, true);
		if (entity instanceof FleshWormEntity) {
			((FleshWormEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FleshWormEntity) {
			((FleshWormEntity) entity).setAnimation("animation.fleshWorm_disappear");
		}
		TheDeepVoidMod.queueServerWork(30, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.SPAWN_BONE_SPIKES.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIKEDURATION.get(), 0, false, false));
		});
		TheDeepVoidMod.queueServerWork((int) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIKEDURATION.get(), () -> {
			if (entity instanceof FleshWormEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FleshWormEntity.DATA_attacking, false);
			if (entity instanceof FleshWormEntity) {
				((FleshWormEntity) entity).setAnimation("empty");
			}
			if (entity instanceof FleshWormEntity) {
				((FleshWormEntity) entity).setAnimation("animation.fleshWorm_appear");
			}
		});
	}
}
