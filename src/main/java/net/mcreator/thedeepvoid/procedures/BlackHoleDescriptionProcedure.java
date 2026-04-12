package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class BlackHoleDescriptionProcedure {
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
		if (itemstack.getItem() == TheDeepVoidModItems.BLACK_HOLE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.the_deep_void.black_hole.desc").getString())));
			} else {
				tooltip.add(Component.literal((Component.translatable("item.the_deep_void.weapon_tooltip.show").getString())));
			}
			if (itemstack.getOrCreateTag().getDouble("ammo") > 0) {
				tooltip.add(Component.literal(""));
				tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.minecraft.arrow").getString() + " [x" + new java.text.DecimalFormat("##").format(itemstack.getOrCreateTag().getDouble("ammo")) + "]")));
			}
		}
	}
}
