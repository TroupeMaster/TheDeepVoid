package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.SummonedShadowHandEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class SummonedShadowHandOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SummonedShadowHandEntity) {
			((SummonedShadowHandEntity) entity).setAnimation("animation.shadowHand_exit");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 99, false, false));
	}
}
