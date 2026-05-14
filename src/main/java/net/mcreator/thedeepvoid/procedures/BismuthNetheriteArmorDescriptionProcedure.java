package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class BismuthNetheriteArmorDescriptionProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_BOOTS.get()) {
			tooltip.add(Component.literal(""));
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.when_worn").getString())));
					tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.bismuth_netherite.worn").getString())));
				} else {
					tooltip.add(Component.literal((Component.translatable("armors.the_deep_void.press_shift").getString())));
				}
			} else {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal(("\u00A77" + Component.translatable("armors.the_deep_void.when_worn").getString())));
					tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.bismuth_netherite.worn").getString())));
				} else {
					tooltip.add(Component.literal(("\u00A77" + Component.translatable("armors.the_deep_void.press_shift_nofull").getString())));
				}
			}
		}
	}
}
