
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class LacerationMobEffect extends MobEffect {
	public LacerationMobEffect() {
		super(MobEffectCategory.HARMFUL, -65022);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
