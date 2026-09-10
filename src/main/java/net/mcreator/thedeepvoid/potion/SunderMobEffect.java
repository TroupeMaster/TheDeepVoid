
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SunderMobEffect extends MobEffect {
	public SunderMobEffect() {
		super(MobEffectCategory.HARMFUL, -4704457);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
