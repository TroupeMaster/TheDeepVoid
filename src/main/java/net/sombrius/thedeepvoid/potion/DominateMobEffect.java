
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.DominateOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DominateMobEffect extends MobEffect {
	public DominateMobEffect() {
		super(MobEffectCategory.NEUTRAL, -2565928);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DominateOnEffectActiveTickProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
