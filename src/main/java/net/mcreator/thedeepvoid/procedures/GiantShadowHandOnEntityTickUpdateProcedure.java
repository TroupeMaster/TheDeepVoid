package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.GiantShadowHandEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class GiantShadowHandOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, 10, 0));
		TheDeepVoidMod.queueServerWork(250, () -> {
			if (entity.getPersistentData().getBoolean("despawn") == false) {
				entity.getPersistentData().putBoolean("despawn", true);
				if (entity instanceof GiantShadowHandEntity) {
					((GiantShadowHandEntity) entity).setAnimation("animation.giantShadowHand_despawn");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 99, false, false));
			}
		});
		if (entity.getPersistentData().getBoolean("despawn") == true) {
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}
