
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.RotOnEffectActiveTickProcedure;
import net.mcreator.thedeepvoid.procedures.RotActiveTickConditionProcedure;

public class RotMobEffect extends MobEffect {
	public RotMobEffect() {
		super(MobEffectCategory.HARMFUL, -11188679);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RotOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return RotActiveTickConditionProcedure.execute(duration);
	}
}
