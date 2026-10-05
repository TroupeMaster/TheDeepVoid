
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.IchorBurnOnEffectActiveTickProcedure;
import net.sombrius.thedeepvoid.procedures.IchorBurnActiveTickConditionProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class IchorBurnMobEffect extends MobEffect {
	public IchorBurnMobEffect() {
		super(MobEffectCategory.HARMFUL, -9728);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		IchorBurnOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return IchorBurnActiveTickConditionProcedure.execute(duration);
	}
}
