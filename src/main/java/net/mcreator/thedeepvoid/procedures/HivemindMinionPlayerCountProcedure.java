package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.ArrayList;

public class HivemindMinionPlayerCountProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.DOBOSSHPSCALING.get() == true) {
			if (world.players().size() > 1) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					entity.getPersistentData().putDouble("playerCount", (entity.getPersistentData().getDouble("playerCount") + 1));
				}
			}
			if (entity.getPersistentData().getDouble("playerCount") > 1) {
				entity.getPersistentData().putDouble("baseHealth", ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue());
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((entity.getPersistentData().getDouble("baseHealth") + entity.getPersistentData().getDouble("baseHealth") * 0.35 * entity.getPersistentData().getDouble("playerCount")));
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			}
		}
	}
}
