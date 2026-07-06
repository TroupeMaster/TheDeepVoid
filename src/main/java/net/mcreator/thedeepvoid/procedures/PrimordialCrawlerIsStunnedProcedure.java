package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.PrimordialBoneCrawlerEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class PrimordialCrawlerIsStunnedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof PrimordialBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(PrimordialBoneCrawlerEntity.DATA_stun) : 0) > 0) {
			if ((entity instanceof PrimordialBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(PrimordialBoneCrawlerEntity.DATA_stun) : 0) == (double) DeepVoidConfigConfiguration.PRIMORDIALCRAWLERSTUNDURATION.get()) {
				if (entity instanceof PrimordialBoneCrawlerEntity) {
					((PrimordialBoneCrawlerEntity) entity).setAnimation("empty");
				}
				if (entity instanceof PrimordialBoneCrawlerEntity) {
					((PrimordialBoneCrawlerEntity) entity).setAnimation("animation.primordialCrawler_stun");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) Double.POSITIVE_INFINITY, 99, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) Double.POSITIVE_INFINITY, 99, false, false));
			}
			if ((entity instanceof PrimordialBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(PrimordialBoneCrawlerEntity.DATA_stun) : 0) == 1) {
				if (entity instanceof PrimordialBoneCrawlerEntity) {
					((PrimordialBoneCrawlerEntity) entity).setAnimation("empty");
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAKNESS);
			}
			if (entity instanceof PrimordialBoneCrawlerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrimordialBoneCrawlerEntity.DATA_stun, (int) ((entity instanceof PrimordialBoneCrawlerEntity _datEntI ? _datEntI.getEntityData().get(PrimordialBoneCrawlerEntity.DATA_stun) : 0) - 1));
		}
	}
}
