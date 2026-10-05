
package net.sombrius.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class VulnerableMobEffect extends MobEffect {
	public VulnerableMobEffect() {
		super(MobEffectCategory.HARMFUL, -12058624);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
