
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.TerrifiedOnEffectActiveTickProcedure;

public class TerrifiedMobEffect extends MobEffect {
	public TerrifiedMobEffect() {
		super(MobEffectCategory.HARMFUL, -10461088);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TerrifiedOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
