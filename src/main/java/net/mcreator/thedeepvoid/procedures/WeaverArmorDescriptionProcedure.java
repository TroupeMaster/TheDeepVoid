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
public class WeaverArmorDescriptionProcedure {
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
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get()) {
			tooltip.add(Component.literal(""));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.weaver_mask.when_worn").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver_mask.worn1").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver_mask.worn2").getString())));
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.weaver_mask.when_kill").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver_mask.kill").getString())));
			} else {
				tooltip.add(Component.literal((Component.translatable("armors.the_deep_void.press_shift").getString())));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.HARVESTER_MASK_HELMET.get()) {
			tooltip.add(Component.literal(""));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A72" + Component.translatable("armors.the_deep_void.harvest_mask.counts").getString())));
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.weaver_mask.when_worn").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.harvest_mask.worn").getString())));
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.harvest_mask.when_attack").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.harvest_mask.attack").getString())));
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.harvest_mask.when_kill").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.harvest_mask.kill").getString())));
			} else {
				tooltip.add(Component.literal((Component.translatable("armors.the_deep_void.press_shift").getString())));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get()) {
			tooltip.add(Component.literal(""));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.weaver_robe.when_attack").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver_robe.attack").getString())));
			} else {
				tooltip.add(Component.literal((Component.translatable("armors.the_deep_void.press_shift").getString())));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get()) {
			tooltip.add(Component.literal(""));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.weaver_leggings.when_attack").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver_leggings.attack").getString())));
			} else {
				tooltip.add(Component.literal((Component.translatable("armors.the_deep_void.press_shift").getString())));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get()) {
			tooltip.add(Component.literal(""));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.weaver_boots.gravity_key_press").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver_boots.on_gravity_key_press").getString())));
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.key_press").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver_boots.on_key_press").getString())));
			} else {
				tooltip.add(Component.literal((Component.translatable("armors.the_deep_void.press_shift").getString())));
			}
		}
		if ((itemstack.getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.HARVESTER_MASK_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get()
				|| itemstack.getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get() || itemstack.getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get())
				&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get()
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HARVESTER_MASK_HELMET.get())
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A76" + Component.translatable("armors.the_deep_void.weaver.full").getString())));
				tooltip.add(Component.literal((" \u00A77-" + Component.translatable("armors.the_deep_void.weaver.descr").getString())));
			}
		}
	}
}
