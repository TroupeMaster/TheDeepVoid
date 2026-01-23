
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CrateMagnetMobEffect extends MobEffect {
	public CrateMagnetMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13697024);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
