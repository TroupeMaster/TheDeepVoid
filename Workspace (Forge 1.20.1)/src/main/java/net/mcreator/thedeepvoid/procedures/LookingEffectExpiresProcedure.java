package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.entity.StalkingStalkerEntity;

public class LookingEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof StalkingStalkerEntity) {
			entity.getPersistentData().putBoolean("deep_void:lookingRightNow", false);
			entity.getPersistentData().putBoolean("deep_void:despawning", false);
			if (entity instanceof StalkingStalkerEntity) {
				((StalkingStalkerEntity) entity).setAnimation("animation.stalker_digOut");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 75, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75, 99, false, false));
		}
	}
}
