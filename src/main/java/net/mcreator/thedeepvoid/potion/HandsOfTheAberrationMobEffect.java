
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.HandsOfTheAberrationOnEffectActiveTickProcedure;

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
