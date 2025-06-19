package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class InvisibleHandsOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 5, 0, false, false));
		if (Math.random() < 0.1) {
			entity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -2, 2)), (Mth.nextDouble(RandomSource.create(), -2, 2)), (Mth.nextDouble(RandomSource.create(), -2, 2))));
		}
	}
}
