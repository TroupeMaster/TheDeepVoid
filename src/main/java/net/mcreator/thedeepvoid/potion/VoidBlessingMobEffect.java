
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class VoidBlessingMobEffect extends MobEffect {
	public VoidBlessingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -7566196);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
