package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class PlaceSepulcherCommandExecutedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheDeepVoidModVariables.MapVariables.get(world).WeaverTemplePlaced = false;
		TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("The Sepulcher will be generated on next world load"), false);
	}
}
