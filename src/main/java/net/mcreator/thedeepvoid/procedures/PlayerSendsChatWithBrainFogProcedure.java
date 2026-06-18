package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class PlayerSendsChatWithBrainFogProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer(), event.getRawText());
	}

	public static void execute(LevelAccessor world, Entity entity, String text) {
		execute(null, world, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		boolean playerHasBrainFog = false;
		playerHasBrainFog = false;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) && playerHasBrainFog == false) {
				playerHasBrainFog = true;
			}
		}
		if (playerHasBrainFog == true) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (!(entityiterator instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()))) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<" + entity.getDisplayName().getString() + "> " + text)), false);
				} else if (entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get())) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<\u00A7k" + entity.getDisplayName().getString() + "> " + text)), false);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get())) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<\u00A7k" + entity.getDisplayName().getString() + "> " + text)), false);
			}
		}
	}
}
