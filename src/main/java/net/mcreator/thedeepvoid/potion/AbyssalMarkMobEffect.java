
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.AbyssalMarkOnEffectActiveTickProcedure;
import net.mcreator.thedeepvoid.procedures.AbyssalMarkEffectExpiresProcedure;

public class AbyssalMarkMobEffect extends MobEffect {
	public AbyssalMarkMobEffect() {
		super(MobEffectCategory.NEUTRAL, -14935012);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AbyssalMarkOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AbyssalMarkEffectExpiresProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
