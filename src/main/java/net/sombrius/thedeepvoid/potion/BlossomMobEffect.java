
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.BlossomOnEffectActiveTickProcedure;
import net.sombrius.thedeepvoid.procedures.BlossomActiveTickConditionProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BlossomMobEffect extends MobEffect {
	public BlossomMobEffect() {
		super(MobEffectCategory.HARMFUL, -9870544);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BlossomOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return BlossomActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
