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
public class NeedleDescriptionsProcedure {
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
		if (itemstack.getItem() == TheDeepVoidModItems.REGENERATION_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.regeneration").getString() + " II (00:10)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.ABSORPTION_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.absorption").getString() + " (00:30)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.RESISTANCE_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.resistance").getString() + " (00:10)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.GLOWING_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A7c" + Component.translatable("effect.minecraft.glowing").getString() + " (01:30)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.ROT_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A7c" + Component.translatable("effect.the_deep_void.rot").getString() + " (00:10)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.JUMP_BOOST_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.jump_boost").getString() + " II (01:00)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.HEXED_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A7c" + Component.translatable("effect.the_deep_void.hexed").getString() + " (00:30)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.FIRE_RESISTANCE_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.fire_resistance").getString() + " (01:00)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.POISON_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.poison").getString() + " (00:10)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.SPEED_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.speed").getString() + " II (01:00)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.HEALTH_BOOST_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.health_boost").getString() + " II (00:30)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.WITHER_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A7c" + Component.translatable("effect.minecraft.wither").getString() + " (00:10)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.SATURATION_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.saturation").getString() + " (00:03)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.INSTANT_DAMAGE_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A7c" + Component.translatable("effect.minecraft.instant_damage").getString() + " (00:00)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.STRENGTH_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.strength").getString() + " (00:10)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.WEAKNESS_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A7c" + Component.translatable("effect.minecraft.weakness").getString() + " (00:20)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.SLOWNESS_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A7c" + Component.translatable("effect.minecraft.slowness").getString() + " (01:00)")));
		} else if (itemstack.getItem() == TheDeepVoidModItems.INVISIBILITY_NEEDLE.get()) {
			tooltip.add(Component.literal(("\u00A79" + Component.translatable("effect.minecraft.invisibility").getString() + " (01:00)")));
		}
	}
}
