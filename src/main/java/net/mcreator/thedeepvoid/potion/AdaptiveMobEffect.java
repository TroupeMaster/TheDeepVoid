
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AdaptiveMobEffect extends MobEffect {
	public AdaptiveMobEffect() {
		super(MobEffectCategory.NEUTRAL, -11329513);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
