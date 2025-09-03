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
public class LickerHookDescriptionProcedure {
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
		if (itemstack.getItem() == TheDeepVoidModItems.LICKER_HOOK.get()) {
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr1").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr2").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr3").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr4").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr5").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr6").getString())));
		}
		if (itemstack.getItem() == TheDeepVoidModItems.GRIM_LICKER_HOOK.get()) {
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.grim_licker_hook.descr1").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr1").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.grim_licker_hook.descr2").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr3").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr4").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr5").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr6").getString())));
		}
		if (itemstack.getItem() == TheDeepVoidModItems.VENGEFUL_LICKER_HOOK.get()) {
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.grim_licker_hook.descr1").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr1").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.vengeful_licker_hook.descr1").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr3").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr4").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr5").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.licker_hook.descr6").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.vengeful_licker_hook.descr2").getString())));
			tooltip.add(Component.literal((Component.translatable("item.the_deep_void.vengeful_licker_hook.descr3").getString())));
		}
	}
}
