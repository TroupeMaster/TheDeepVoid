
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.BrainFogOnEffectActiveTickProcedure;

public class BrainFogMobEffect extends MobEffect {
	public BrainFogMobEffect() {
		super(MobEffectCategory.NEUTRAL, -4339201);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BrainFogOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
