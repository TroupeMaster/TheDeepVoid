package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ScareTrimDescriptionProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == TheDeepVoidModItems.SCARE_ARMOR_TRIM.get()) {
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scare_armor_trim.descr1").getString())));
			tooltip.add(Component.literal(" "));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scare_armor_trim.descr2").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scare_armor_trim.descr3").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scare_armor_trim.descr4").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scare_armor_trim.descr5").getString())));
		}
		if (itemstack.getItem() == TheDeepVoidModItems.SCAVENGER_ARMOR_TRIM.get()) {
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scavenger_armor_trim.descr1").getString())));
			tooltip.add(Component.literal(" "));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scavenger_armor_trim.descr2").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scavenger_armor_trim.descr3").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scavenger_armor_trim.descr4").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.scavenger_armor_trim.descr5").getString())));
		}
		if (itemstack.getItem() == TheDeepVoidModItems.SORROW_ARMOR_TRIM.get()) {
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.sorrow_armor_trim.descr1").getString())));
			tooltip.add(Component.literal(" "));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.sorrow_armor_trim.descr2").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.sorrow_armor_trim.descr3").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.sorrow_armor_trim.descr4").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.sorrow_armor_trim.descr5").getString())));
		}
	}
}
