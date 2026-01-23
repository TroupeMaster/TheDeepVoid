package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class IchorBurnOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("deep_void:ichorBurn") >= 10) {
			entity.getPersistentData().putDouble("deep_void:ichorBurn", 0);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)),
					(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ICHOR_BURN.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ICHOR_BURN.get()).getAmplifier() : 0) > 1
							? (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ICHOR_BURN.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ICHOR_BURN.get()).getAmplifier() : 0)
							: 1.25));
		} else {
			entity.getPersistentData().putDouble("deep_void:ichorBurn", (entity.getPersistentData().getDouble("deep_void:ichorBurn") + 1));
		}
	}
}
