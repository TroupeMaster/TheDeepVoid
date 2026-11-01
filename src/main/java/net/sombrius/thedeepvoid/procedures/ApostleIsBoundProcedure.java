package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.entity.ApostleBossEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class ApostleIsBoundProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("binding") > 0) {
			entity.getPersistentData().putDouble("binding", (entity.getPersistentData().getDouble("binding") - 1));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99, false, false));
		} else if (entity.getPersistentData().getDouble("binding") <= 0 && entity.getPersistentData().getBoolean("removeChains") == false) {
			entity.getPersistentData().putBoolean("removeChains", true);
			if (entity instanceof ApostleBossEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ApostleBossEntity.DATA_doingAttack, false);
		}
	}
}
