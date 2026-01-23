
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.BlossomOnEffectActiveTickProcedure;

public class BlossomMobEffect extends MobEffect {
	public BlossomMobEffect() {
		super(MobEffectCategory.HARMFUL, -9870544);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BlossomOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
