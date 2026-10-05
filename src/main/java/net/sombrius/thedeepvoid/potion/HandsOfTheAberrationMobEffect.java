
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.HandsOfTheAberrationOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class HandsOfTheAberrationMobEffect extends MobEffect {
	public HandsOfTheAberrationMobEffect() {
		super(MobEffectCategory.HARMFUL, -7038559);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HandsOfTheAberrationOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
