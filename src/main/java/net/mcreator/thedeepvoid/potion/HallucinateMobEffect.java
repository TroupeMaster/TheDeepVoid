
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.HallucinateEyesProcedure;

public class HallucinateMobEffect extends MobEffect {
	public HallucinateMobEffect() {
		super(MobEffectCategory.HARMFUL, -13553359);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HallucinateEyesProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
