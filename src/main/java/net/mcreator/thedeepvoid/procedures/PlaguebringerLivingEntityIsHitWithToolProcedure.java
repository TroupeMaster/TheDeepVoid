package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class PlaguebringerLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double level = 0;
		double duration = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.PLAGUE.get())) {
			level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.PLAGUE.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.PLAGUE.get()).getAmplifier() : 0;
			duration = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.PLAGUE.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.PLAGUE.get()).getDuration() : 0;
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheDeepVoidModMobEffects.PLAGUE.get());
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PLAGUE.get(), (int) Math.round(duration * 0.8), (int) (level + 1)));
		}
	}
}
