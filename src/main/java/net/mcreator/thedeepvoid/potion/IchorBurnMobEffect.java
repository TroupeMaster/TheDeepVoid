
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.IchorBurnOnEffectActiveTickProcedure;

public class IchorBurnMobEffect extends MobEffect {
	public IchorBurnMobEffect() {
		super(MobEffectCategory.HARMFUL, -9728);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		IchorBurnOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
