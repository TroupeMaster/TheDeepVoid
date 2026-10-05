
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.PainKillerOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PainKillerMobEffect extends MobEffect {
	public PainKillerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10747133);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PainKillerOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
