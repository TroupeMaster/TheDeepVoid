
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.MotherlyCallOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MotherlyCallMobEffect extends MobEffect {
	public MotherlyCallMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -12566982);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		MotherlyCallOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
