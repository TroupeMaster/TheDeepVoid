
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.FixationOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FixationMobEffect extends MobEffect {
	public FixationMobEffect() {
		super(MobEffectCategory.HARMFUL, -16448251);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FixationOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
