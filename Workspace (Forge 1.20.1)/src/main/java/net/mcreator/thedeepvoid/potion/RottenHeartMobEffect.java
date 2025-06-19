
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.RottenHeartOnEffectActiveTickProcedure;

public class RottenHeartMobEffect extends MobEffect {
	public RottenHeartMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14145496);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RottenHeartOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
