
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.AdaptedEffectStartedappliedProcedure;
import net.sombrius.thedeepvoid.procedures.AdaptedEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AdaptedMobEffect extends MobEffect {
	public AdaptedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16748642);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		AdaptedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AdaptedEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
