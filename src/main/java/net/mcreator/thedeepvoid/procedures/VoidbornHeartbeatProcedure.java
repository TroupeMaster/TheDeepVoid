package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.entity.VoidbornEntity;

import java.util.List;
import java.util.Comparator;

public class VoidbornHeartbeatProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty())) {
			if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) <= 0) {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, 28);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) - 1));
			}
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
			if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) <= 0) {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, 17);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) - 1));
			}
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())) {
			if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) <= 0) {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, 10);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) - 1));
			}
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
			if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) <= 0) {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, 8);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) - 1));
			}
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
			if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) <= 0) {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, 6);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) - 1));
			}
		} else {
			if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) <= 0) {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, 4);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:player_heartbeat player @s ~ ~ ~ 1 1 1");
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof VoidbornEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VoidbornEntity.DATA_heartbeat, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_heartbeat) : 0) - 1));
			}
		}
	}
}
