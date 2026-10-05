
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.MadnessOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MadnessMobEffect extends MobEffect {
	public MadnessMobEffect() {
		super(MobEffectCategory.HARMFUL, -13099233);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		MadnessOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
