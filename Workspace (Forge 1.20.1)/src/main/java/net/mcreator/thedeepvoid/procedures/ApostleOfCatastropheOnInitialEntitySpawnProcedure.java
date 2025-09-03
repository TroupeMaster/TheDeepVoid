package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.ArrayList;

public class ApostleOfCatastropheOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("deep_void:forgeX", x);
		entity.getPersistentData().putDouble("deep_void:forgeY", y);
		entity.getPersistentData().putDouble("deep_void:forgeZ", z);
		if (world.players().size() > 1) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				entity.getPersistentData().putDouble("deep_void:playerCount", (entity.getPersistentData().getDouble("deep_void:playerCount") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:playerCount") > 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, (int) Double.POSITIVE_INFINITY, (int) (entity.getPersistentData().getDouble("deep_void:playerCount") * 16), false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, 200, false, false));
		}
		if (entity.getPersistentData().getDouble("deep_void:playerCount") > 3) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) Double.POSITIVE_INFINITY, (int) Math.floor(entity.getPersistentData().getDouble("deep_void:playerCount") / 4), false, false));
		}
	}
}
