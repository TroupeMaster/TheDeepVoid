package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;

public class IronSpikeProjectileHitsLivingEntityProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (immediatesourceentity instanceof AbstractArrow _abstractArrow)
			_abstractArrow.setBaseDamage(((immediatesourceentity instanceof AbstractArrow _arrowContext ? _arrowContext.getBaseDamage() : 0.0D) + (double) DeepVoidConfigConfiguration.VEHEMENCEPIERCE.get()));
	}
}
