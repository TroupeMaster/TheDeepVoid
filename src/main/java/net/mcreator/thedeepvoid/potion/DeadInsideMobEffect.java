
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.DeadInsideOnEffectActiveTickProcedure;

public class DeadInsideMobEffect extends MobEffect {
	public DeadInsideMobEffect() {
		super(MobEffectCategory.HARMFUL, -15527149);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DeadInsideOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
