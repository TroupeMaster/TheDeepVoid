
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.HeavyOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class HeavyMobEffect extends MobEffect {
	public HeavyMobEffect() {
		super(MobEffectCategory.HARMFUL, -14474461);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HeavyOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
