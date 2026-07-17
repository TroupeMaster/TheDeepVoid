package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BrainFogSendChatProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer(), event.getRawText());
	}

	public static void execute(Entity entity, String text) {
		execute(null, entity, text);
	}

	private static void execute(@Nullable Event event, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get())
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.BRAIN_FOG.get()).getAmplifier() : 0) >= 3) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<" + entity.getDisplayName().getString() + "> " + text)), false);
		}
	}
}
