package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.entity.SkullSmasherEntity;
import net.mcreator.thedeepvoid.entity.SawThrowerEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.ArrayList;

public class HivemindMinionPlayerCountProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.DOBOSSHPSCALING.get() == true) {
			if (world.players().size() > 1) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (entity instanceof SawThrowerEntity) {
						if (entity instanceof SawThrowerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SawThrowerEntity.DATA_playerCount, (int) ((entity instanceof SawThrowerEntity _datEntI ? _datEntI.getEntityData().get(SawThrowerEntity.DATA_playerCount) : 0) + 1));
					} else if (entity instanceof SkullSmasherEntity) {
						if (entity instanceof SkullSmasherEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SkullSmasherEntity.DATA_playerCount, (int) ((entity instanceof SkullSmasherEntity _datEntI ? _datEntI.getEntityData().get(SkullSmasherEntity.DATA_playerCount) : 0) + 1));
					}
				}
			}
			if (entity instanceof SawThrowerEntity) {
				if ((entity instanceof SawThrowerEntity _datEntI ? _datEntI.getEntityData().get(SawThrowerEntity.DATA_playerCount) : 0) > 1) {
					if (entity instanceof SawThrowerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SawThrowerEntity.DATA_baseHealth, (int) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue());
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue(((entity instanceof SawThrowerEntity _datEntI ? _datEntI.getEntityData().get(SawThrowerEntity.DATA_baseHealth) : 0)
									+ (entity instanceof SawThrowerEntity _datEntI ? _datEntI.getEntityData().get(SawThrowerEntity.DATA_baseHealth) : 0) * 0.35
											* (entity instanceof SawThrowerEntity _datEntI ? _datEntI.getEntityData().get(SawThrowerEntity.DATA_playerCount) : 0)));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				}
			} else if (entity instanceof SkullSmasherEntity) {
				if ((entity instanceof SkullSmasherEntity _datEntI ? _datEntI.getEntityData().get(SkullSmasherEntity.DATA_playerCount) : 0) > 1) {
					if (entity instanceof SkullSmasherEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SkullSmasherEntity.DATA_baseHealth, (int) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue());
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue(((entity instanceof SkullSmasherEntity _datEntI ? _datEntI.getEntityData().get(SkullSmasherEntity.DATA_baseHealth) : 0)
									+ (entity instanceof SkullSmasherEntity _datEntI ? _datEntI.getEntityData().get(SkullSmasherEntity.DATA_baseHealth) : 0) * 0.35
											* (entity instanceof SkullSmasherEntity _datEntI ? _datEntI.getEntityData().get(SkullSmasherEntity.DATA_playerCount) : 0)));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				}
			}
		}
	}
}
