
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TerrorMobEffect extends MobEffect {
	public TerrorMobEffect() {
		super(MobEffectCategory.NEUTRAL, -14745558);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
