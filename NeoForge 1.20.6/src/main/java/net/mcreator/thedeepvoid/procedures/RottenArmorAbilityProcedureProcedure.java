package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RottenArmorAbilityProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).RottenArmorAbility != 0) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.RottenArmorAbility = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).RottenArmorAbility - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).RottenArmorAbility)), true);
		}
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).VoidCloakAbility != 0) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.VoidCloakAbility = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).VoidCloakAbility - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).VoidCloakAbility)), true);
		}
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).flesh_roar != 0) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.flesh_roar = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).flesh_roar - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).flesh_roar)), true);
		}
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).allseeingArmor != 0) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.allseeingArmor = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).allseeingArmor - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).allseeingArmor)), true);
		}
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).weaverBoots != 0) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.weaverBoots = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).weaverBoots - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).weaverBoots)), true);
		}
	}
}
