package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;

public class PlayMusicPitchBlackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MusicReplace = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicTick == 1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound the_deep_void:pitch_black record @s");
				}
			}
		} else if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicTick == 1700) {
			{
				double _setval = 0;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MusicTick = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (!(!world.getEntitiesOfClass(MisanthropicHivemindEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(FleshWormEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
			{
				double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicWait + 1;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MusicWait = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicWait > 200) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "stopsound @s record the_deep_void:pitch_black");
					}
				}
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MusicWait = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MusicTick = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "";
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MusicPlay = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = false;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MusicLock = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			{
				double _setval = 0;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MusicWait = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
