
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.GoldenBloodOnEffectActiveTickProcedure;

public class GoldenBloodMobEffect extends MobEffect {
	public GoldenBloodMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -9728);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GoldenBloodOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
