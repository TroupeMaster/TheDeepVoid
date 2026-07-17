
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class GluttonyMobEffect extends MobEffect {
	public GluttonyMobEffect() {
		super(MobEffectCategory.NEUTRAL, -9566204);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
