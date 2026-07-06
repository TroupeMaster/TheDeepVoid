
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.StickyOnEffectActiveTickProcedure;

public class StickyMobEffect extends MobEffect {
	public StickyMobEffect() {
		super(MobEffectCategory.NEUTRAL, -7233905);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		StickyOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
