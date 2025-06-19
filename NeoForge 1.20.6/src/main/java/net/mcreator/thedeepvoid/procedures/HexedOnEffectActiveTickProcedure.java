package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class HexedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, (y + 0.8), z, 2, 0.1, 0.2, 0.1, 0.1);
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.HEXED) ? _livEnt.getEffect(TheDeepVoidModMobEffects.HEXED).getAmplifier() : 0) > 1) {
			entity.getPersistentData().putDouble("deep_void:hexedBuildUp", (entity.getPersistentData().getDouble("deep_void:hexedBuildUp") + 0.5
					+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.HEXED) ? _livEnt.getEffect(TheDeepVoidModMobEffects.HEXED).getAmplifier() : 0) / 2));
		} else {
			entity.getPersistentData().putDouble("deep_void:hexedBuildUp", (entity.getPersistentData().getDouble("deep_void:hexedBuildUp") + 0.5));
		}
	}
}
