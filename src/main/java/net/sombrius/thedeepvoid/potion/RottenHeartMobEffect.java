
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.RottenHeartOnEffectActiveTickProcedure;
import net.sombrius.thedeepvoid.procedures.RottenHeartEffectStartedappliedProcedure;
import net.sombrius.thedeepvoid.procedures.RottenHeartEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RottenHeartMobEffect extends MobEffect {
	public RottenHeartMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14145496);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		RottenHeartEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RottenHeartOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		RottenHeartEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
