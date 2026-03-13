package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class VoidPelletProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		if (!(entity == sourceentity)) {
			if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TheDeepVoidModMobEffects.ABYSSAL_MARK.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ABYSSAL_MARK.get(), 12, 0));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ABYSSAL_MARK.get(), 12,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ABYSSAL_MARK.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ABYSSAL_MARK.get()).getAmplifier() : 0) + 1)));
			}
		}
	}
}
