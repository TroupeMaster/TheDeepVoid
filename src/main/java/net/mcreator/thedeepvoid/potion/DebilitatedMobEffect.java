
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.DebilitatedEffectStartedappliedProcedure;
import net.mcreator.thedeepvoid.procedures.DebilitatedEffectExpiresProcedure;

public class DebilitatedMobEffect extends MobEffect {
	public DebilitatedMobEffect() {
		super(MobEffectCategory.NEUTRAL, -11122637);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DebilitatedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		DebilitatedEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
