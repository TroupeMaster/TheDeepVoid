
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thedeepvoid.procedures.AmbrosiaWithdrawalOnEffectActiveTickProcedure;
import net.mcreator.thedeepvoid.procedures.AmbrosiaWithdrawalEffectExpiresProcedure;

public class AmbrosiaWithdrawalMobEffect extends MobEffect {
	public AmbrosiaWithdrawalMobEffect() {
		super(MobEffectCategory.HARMFUL, -14792947);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AmbrosiaWithdrawalOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AmbrosiaWithdrawalEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
