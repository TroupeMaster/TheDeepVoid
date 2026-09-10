package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;

public class ShotgunPelletProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _mobEffectContext) {
			for (MobEffectInstance mobeffectiterator : _mobEffectContext.getActiveEffects()) {
				if (mobeffectiterator.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
					if (entity instanceof LivingEntity _livingEntity)
						_livingEntity.addEffect(mobeffectiterator);
				}
			}
		}
	}
}
