
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.InvisibleHandsOnEffectActiveTickProcedure;

public class InvisibleHandsMobEffect extends MobEffect {
	public InvisibleHandsMobEffect() {
		super(MobEffectCategory.HARMFUL, -528129);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		InvisibleHandsOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
