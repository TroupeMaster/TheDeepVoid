package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class AbyssalMarkOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData()
				.getDouble("abyssalMarkLevel") != (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ABYSSAL_MARK.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ABYSSAL_MARK.get()).getAmplifier() : 0)) {
			entity.getPersistentData().putDouble("abyssalMarkLevel",
					(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ABYSSAL_MARK.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ABYSSAL_MARK.get()).getAmplifier() : 0));
		}
	}
}
