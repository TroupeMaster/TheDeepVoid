
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.PlagueOnEffectActiveTickProcedure;
import net.mcreator.thedeepvoid.procedures.PlagueActiveTickConditionProcedure;

public class PlagueMobEffect extends MobEffect {
	public PlagueMobEffect() {
		super(MobEffectCategory.HARMFUL, -11358952);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PlagueOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return PlagueActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
