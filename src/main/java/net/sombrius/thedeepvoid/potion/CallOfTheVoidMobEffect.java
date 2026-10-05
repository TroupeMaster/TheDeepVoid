
package net.sombrius.thedeepvoid.potion;

import net.sombrius.thedeepvoid.procedures.CallOfTheVoidOnEffectActiveTickProcedure;
import net.sombrius.thedeepvoid.procedures.CallOfTheVoidEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CallOfTheVoidMobEffect extends MobEffect {
	public CallOfTheVoidMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CallOfTheVoidOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		CallOfTheVoidEffectExpiresProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
