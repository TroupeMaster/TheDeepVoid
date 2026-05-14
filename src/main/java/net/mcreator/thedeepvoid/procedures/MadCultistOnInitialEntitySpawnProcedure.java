package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.MadCultistEntity;

public class MadCultistOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.5) {
			if (entity instanceof MadCultistEntity _datEntSetL)
				_datEntSetL.getEntityData().set(MadCultistEntity.DATA_patrol, true);
		} else {
			if (entity instanceof MadCultistEntity) {
				((MadCultistEntity) entity).setAnimation("animation.madCultist_pray");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) Double.POSITIVE_INFINITY, 99, false, false));
		}
	}
}
