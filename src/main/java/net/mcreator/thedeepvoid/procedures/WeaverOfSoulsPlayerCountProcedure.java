package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsBossEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class WeaverOfSoulsPlayerCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.DOBOSSHPSCALING.get() == true) {
			if (world.players().size() > 1) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_playerCount, (int) ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_playerCount) : 0) + 1));
				}
			}
			if ((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_playerCount) : 0) > 1) {
				if (entity instanceof WeaverOfSoulsBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverOfSoulsBossEntity.DATA_baseHealth, (int) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue());
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue(((entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_baseHealth) : 0)
								+ (entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_baseHealth) : 0) * 0.35
										* (entity instanceof WeaverOfSoulsBossEntity _datEntI ? _datEntI.getEntityData().get(WeaverOfSoulsBossEntity.DATA_playerCount) : 0)));
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			}
		}
		entity.getPersistentData().putDouble("deep_void:startingX", x);
		entity.getPersistentData().putDouble("deep_void:startingY", (y - 1));
		entity.getPersistentData().putDouble("deep_void:startingZ", z);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					{
						boolean _setval = true;
						entityiterator.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.noHit = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A79\u00A7kDisc \u00A79Darkmare - by Dark Fantasy Studio \u00A79\u00A7kDisc"), true);
				}
			}
		}
	}
}
