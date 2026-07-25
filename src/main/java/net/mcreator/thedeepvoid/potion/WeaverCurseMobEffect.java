
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.WeaverCurseOnEffectActiveTickProcedure;

public class WeaverCurseMobEffect extends MobEffect {
	public WeaverCurseMobEffect() {
		super(MobEffectCategory.NEUTRAL, -12124160);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		WeaverCurseOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
