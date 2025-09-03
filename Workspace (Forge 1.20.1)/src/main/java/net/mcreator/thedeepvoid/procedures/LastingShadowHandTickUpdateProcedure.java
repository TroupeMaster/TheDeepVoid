package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.ShadowHandEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class LastingShadowHandTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(!world.getEntitiesOfClass(WeaverOfSoulsEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())) {
			if (entity instanceof ShadowHandEntity) {
				((ShadowHandEntity) entity).setAnimation("animation.shadowHand_enter");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 99, false, false));
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}
