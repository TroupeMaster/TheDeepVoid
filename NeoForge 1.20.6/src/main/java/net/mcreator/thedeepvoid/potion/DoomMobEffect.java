
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.DoomEffectStartedappliedProcedure;

public class DoomMobEffect extends MobEffect {
	public DoomMobEffect() {
		super(MobEffectCategory.HARMFUL, -13524993);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		DoomEffectStartedappliedProcedure.execute(entity.level(), entity);
	}
}
