package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class PrimordialCrawlerShootUpProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PrimordialBoneCrawlerEntity) {
			((PrimordialBoneCrawlerEntity) entity).setAnimation("animation.primordialCrawler_shoot");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 99, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 70, 99, false, false));
		TheDeepVoidMod.queueServerWork(25, () -> {
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_shooting, 35);
		});
	}
}
