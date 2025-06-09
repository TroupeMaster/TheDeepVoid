
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.BloodBoilOnEffectActiveTickProcedure;
import net.mcreator.thedeepvoid.procedures.BloodBoilEffectExpiresProcedure;

public class BloodBoilMobEffect extends MobEffect {
	public BloodBoilMobEffect() {
		super(MobEffectCategory.NEUTRAL, -458752);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BloodBoilOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BloodBoilEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
