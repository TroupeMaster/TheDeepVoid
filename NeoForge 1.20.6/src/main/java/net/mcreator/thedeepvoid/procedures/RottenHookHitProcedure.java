package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class RottenHookHitProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ROT, 120, 0));
		sourceentity.setDeltaMovement(new Vec3(((entity.getX() - sourceentity.getX()) * 0.1), ((entity.getY() - sourceentity.getY()) * 0.1), ((entity.getZ() - sourceentity.getZ()) * 0.1)));
	}
}
