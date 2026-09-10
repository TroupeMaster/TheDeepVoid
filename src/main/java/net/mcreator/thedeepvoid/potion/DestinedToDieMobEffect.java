
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DestinedToDieMobEffect extends MobEffect {
	public DestinedToDieMobEffect() {
		super(MobEffectCategory.NEUTRAL, -14221245);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
