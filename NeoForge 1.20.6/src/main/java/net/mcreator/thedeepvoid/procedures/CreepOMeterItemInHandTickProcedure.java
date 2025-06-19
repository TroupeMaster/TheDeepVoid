package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class CreepOMeterItemInHandTickProcedure {
	public static void execute(double y, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (y >= 0) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("deep_void:secondFunction") == true) {
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerStalkCount < (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() / 2) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).stalkWatcherCount)), true);
				} else if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerStalkCount >= (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() / 2) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerStalkCount)), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount)), true);
			}
		} else {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("deep_void:secondFunction") == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinateHurt)), true);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).NightmareCount)), true);
			}
		}
	}
}
