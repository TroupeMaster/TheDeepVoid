
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.DecompositionOnEffectActiveTickProcedure;

public class DecompositionMobEffect extends MobEffect {
	public DecompositionMobEffect() {
		super(MobEffectCategory.HARMFUL, -14804711);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DecompositionOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
