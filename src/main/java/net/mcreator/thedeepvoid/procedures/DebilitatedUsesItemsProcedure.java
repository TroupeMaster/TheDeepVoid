package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DebilitatedUsesItemsProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheDeepVoidModMobEffects.DEBILITATED.get()) && !itemstack.getItem().isEdible()) {
			if (Math.random() < 0.68) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(TheDeepVoidModMobEffects.TERROR.get())) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 160);
			if (itemstack.getItem() instanceof BowItem || itemstack.getItem() instanceof CrossbowItem) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}
