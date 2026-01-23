package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class PlagueOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("deep_void:plague") >= 30
				- (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.PLAGUE.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.PLAGUE.get()).getAmplifier() : 0) * 2) {
			entity.getPersistentData().putDouble("deep_void:plague", 0);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
					(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.PLAGUE.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.PLAGUE.get()).getAmplifier() : 0) + 1));
		} else {
			entity.getPersistentData().putDouble("deep_void:plague", (entity.getPersistentData().getDouble("deep_void:plague") + 1));
		}
	}
}
