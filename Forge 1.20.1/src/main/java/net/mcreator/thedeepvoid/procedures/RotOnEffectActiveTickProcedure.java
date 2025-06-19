package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class RotOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double count = 0;
		if (entity.getPersistentData().getDouble("rotCount") == 15) {
			entity.getPersistentData().putDouble("rotCount", 0);
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROT.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROT.get()).getAmplifier() : 0) > 1) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
						(float) (0.5 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROT.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROT.get()).getAmplifier() : 0) * 0.5));
			} else {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), (float) 0.5);
			}
		} else {
			entity.getPersistentData().putDouble("rotCount", (entity.getPersistentData().getDouble("rotCount") + 1));
		}
	}
}
