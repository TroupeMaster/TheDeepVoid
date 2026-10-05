package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.FoolEaterEntity;
import net.sombrius.thedeepvoid.entity.DeathVultureEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class ManiacEntityIsHurtProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof DeathVultureEntity || sourceentity instanceof FoolEaterEntity) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 39, false, false));
		}
	}
}
