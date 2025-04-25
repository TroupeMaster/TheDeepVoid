package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class SoulOrbRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			{
				boolean _setval = true;
				sourceentity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hasSoulOrb = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			entity.getPersistentData().putBoolean("deep_void:pickedUp", true);
			entity.getPersistentData().putString("deep_void:owner", (sourceentity.getDisplayName().getString()));
			{
				Entity _ent = entity;
				_ent.teleportTo((sourceentity.getX()), (sourceentity.getY() + 2.5), (sourceentity.getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY() + 2.5), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
			}
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7b\u00A7l\u00A7kSOUL \u00A7b\u00A7lBring me to the receptacle. \u00A7b\u00A7l\u00A7kSOUL"), true);
		}
	}
}
