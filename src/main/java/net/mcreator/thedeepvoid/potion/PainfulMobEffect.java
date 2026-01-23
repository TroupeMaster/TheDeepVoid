
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PainfulMobEffect extends MobEffect {
	public PainfulMobEffect() {
		super(MobEffectCategory.HARMFUL, -9761523);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
