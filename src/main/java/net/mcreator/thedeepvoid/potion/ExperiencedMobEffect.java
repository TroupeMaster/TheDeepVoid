
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ExperiencedMobEffect extends MobEffect {
	public ExperiencedMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16736000);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
