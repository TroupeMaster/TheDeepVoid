
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.BarbedTipsOnEffectActiveTickProcedure;
import net.mcreator.thedeepvoid.procedures.BarbedTipsActiveTickConditionProcedure;

public class BarbedTipsMobEffect extends MobEffect {
	public BarbedTipsMobEffect() {
		super(MobEffectCategory.HARMFUL, -11511961);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BarbedTipsOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return BarbedTipsActiveTickConditionProcedure.execute(duration);
	}
}
