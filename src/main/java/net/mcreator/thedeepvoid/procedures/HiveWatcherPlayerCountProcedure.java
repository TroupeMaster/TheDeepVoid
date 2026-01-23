package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class HiveWatcherPlayerCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HiveWatcherEntity) {
			((HiveWatcherEntity) entity).setAnimation("animation.hiveWatcher_spawn");
		}
		TheDeepVoidMod.queueServerWork(10, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
		TheDeepVoidMod.queueServerWork(30, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
		TheDeepVoidMod.queueServerWork(40, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(TheDeepVoidModBlocks.FLESH_BLOCK.get().defaultBlockState()));
		});
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
		entity.getPersistentData().putDouble("deep_void:startingX", x);
		entity.getPersistentData().putDouble("deep_void:startingY", y);
		entity.getPersistentData().putDouble("deep_void:startingZ", z);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
						_player.displayClientMessage(Component.literal("\u00A76\u00A7kDisc \u00A76Monster's Lair - by Darren Curtis Music \u00A76\u00A7kDisc"), true);
				}
			}
		}
	}
}
