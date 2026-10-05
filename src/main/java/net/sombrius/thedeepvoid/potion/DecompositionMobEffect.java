
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.DecompositionOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DecompositionMobEffect extends MobEffect {
	public DecompositionMobEffect() {
		super(MobEffectCategory.HARMFUL, -14804711);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DecompositionOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
