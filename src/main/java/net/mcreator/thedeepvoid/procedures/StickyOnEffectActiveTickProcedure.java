package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class StickyOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isPassenger()) {
			entity.setDeltaMovement(new Vec3(
					(entity.getDeltaMovement().x() * (0.1 - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.STICKY.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.STICKY.get()).getAmplifier() : 0) / 60)),
					(entity.getDeltaMovement().y() * (0.1 - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.STICKY.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.STICKY.get()).getAmplifier() : 0) / 60)),
					(entity.getDeltaMovement().z() * (0.1 - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.STICKY.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.STICKY.get()).getAmplifier() : 0) / 60))));
		}
	}
}
