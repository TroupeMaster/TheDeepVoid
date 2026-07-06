
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.VoidriumMarkOnEffectActiveTickProcedure;

public class VoidriumMarkMobEffect extends MobEffect {
	public VoidriumMarkMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1534733);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		VoidriumMarkOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
