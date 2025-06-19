package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class SoulOrbRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (!sourceentity.isVehicle()) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7b\u00A7l\u00A7kSOUL \u00A7b\u00A7lBring me to the receptacle. \u00A7b\u00A7l\u00A7kSOUL"), true);
				entity.startRiding(sourceentity);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7b\u00A7l\u00A7kSOUL \u00A7b\u00A7lYou cannot take me, make space. \u00A7b\u00A7l\u00A7kSOUL"), true);
			}
		}
	}
}
