
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.BullseyeOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BullseyeMobEffect extends MobEffect {
	public BullseyeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -49624);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BullseyeOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
