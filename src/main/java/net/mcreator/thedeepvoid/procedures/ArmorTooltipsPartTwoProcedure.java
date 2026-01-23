package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import java.util.List;

public class ArmorTooltipsPartTwoProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == TheDeepVoidModItems.HARVESTER_MASK_HELMET.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77Counts toward the full set"));
				tooltip.add(Component.literal("\u00A77When worn:"));
				tooltip.add(Component.literal(" \u00A79-The wearer is immune to Hexed"));
				tooltip.add(Component.literal("\u00A77When attacking a foe with Hexed bare-handed:"));
				tooltip.add(Component.literal(
						" \u00A79-Removes Hexed from the foe, dealing more damage than if the effect would end naturally. The removed Hexed transforms into Absorption with the level based on the damage build up of Hexed. The Absorption has no limits, but is temporary"));
				tooltip.add(Component.literal("\u00A77Upon killing a foe:"));
				tooltip.add(Component.literal(" \u00A79-Transforms their soul into a lethal projectile that targets nearby victims and inflicts Hexed III"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HARVESTER_MASK_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get()) {
			if (itemstack.getItem() == TheDeepVoidModItems.HARVESTER_MASK_HELMET.get()
					|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get()
					|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get()
					|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77Full Armor:"));
					tooltip.add(Component.literal(" \u00A79-Slowly withers away the soul of nearby victims"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.SOUL_WINGS_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.SOUL_WINGS_FLY_CHESTPLATE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
				tooltip.add(Component.literal(" \u00A79-Fly vertically rapidly, but with bad horizontal speed"));
				tooltip.add(Component.literal(" \u00A79-Sneak while flying to fly straight upward with less speed"));
				tooltip.add(Component.literal("\u00A77When worn:"));
				tooltip.add(Component.literal(" \u00A79-Negates fall damage"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.BLOODY_RIB_CAGE_CHESTPLATE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When worn:"));
				tooltip.add(Component.literal(" \u00A79-Fleshkin won't attack the wearer"));
				tooltip.add(Component.literal(" \u00A79-Grants immunity to Poison and Nausea"));
				tooltip.add(Component.literal(" \u00A79-Teeth won't damage the wearer, teeth trap won't activate and pus sacks won't explode"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
	}
}
