package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.GiantShadowHandEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class GiantShadowHandOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 99, false, false));
		if (entity instanceof GiantShadowHandEntity) {
			((GiantShadowHandEntity) entity).setAnimation("animation.giantShadowHand_beforeSpawn");
		}
		TheDeepVoidMod.queueServerWork(80, () -> {
			if (entity instanceof GiantShadowHandEntity) {
				((GiantShadowHandEntity) entity).setAnimation("animation.giantShadowHand_spawn");
			}
		});
	}
}
