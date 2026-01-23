
package net.mcreator.thedeepvoid.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CreatureRepellentMobEffect extends MobEffect {
	public CreatureRepellentMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -394293);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
