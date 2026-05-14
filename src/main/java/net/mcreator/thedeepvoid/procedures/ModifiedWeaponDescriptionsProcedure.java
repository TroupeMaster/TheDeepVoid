package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ModifiedWeaponDescriptionsProcedure {
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
		if (itemstack.getItem() instanceof SwordItem || itemstack.getItem() instanceof PickaxeItem || itemstack.getItem() instanceof AxeItem || itemstack.getItem() instanceof ShovelItem || itemstack.getItem() instanceof HoeItem
				|| itemstack.getItem() instanceof TridentItem) {
			if (itemstack.getOrCreateTag().getBoolean("modification") == true) {
				tooltip.add(Component.literal(""));
				tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.the_deep_void.weapon_tooltip.modification").getString())));
				if (itemstack.getOrCreateTag().getDouble("lavenditeDamageLoss") > 0 || itemstack.getOrCreateTag().getDouble("darksteelDamage") > 0) {
					tooltip.add(Component.literal(((itemstack.getOrCreateTag().getDouble("darksteelDamage") + itemstack.getOrCreateTag().getDouble("lavenditeDamage") * (-1) < 0 ? " \u00A7c" : " \u00A72+") + ""
							+ new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("darksteelDamage") + itemstack.getOrCreateTag().getDouble("lavenditeDamageLoss") * (-1)) + " "
							+ Component.translatable("item.the_deep_void.weapon_tooltip.attack_damage").getString())));
				}
				if (itemstack.getOrCreateTag().getDouble("lavenditeSpeed") > 0 || itemstack.getOrCreateTag().getDouble("rotSpeed") > 0 || itemstack.getOrCreateTag().getDouble("darksteelSpeed") > 0) {
					tooltip.add(Component.literal(
							((itemstack.getOrCreateTag().getDouble("lavenditeSpeed") + itemstack.getOrCreateTag().getDouble("rotSpeed") * (-1) + itemstack.getOrCreateTag().getDouble("darksteelSpeed") * (-1) < 0 ? " \u00A7c" : " \u00A72+") + ""
									+ new java.text.DecimalFormat("##.##")
											.format(itemstack.getOrCreateTag().getDouble("lavenditeSpeed") + itemstack.getOrCreateTag().getDouble("rotSpeed") * (-1) + itemstack.getOrCreateTag().getDouble("darksteelSpeed") * (-1))
									+ " " + Component.translatable("item.the_deep_void.weapon_tooltip.attack_speed").getString())));
				}
				if (itemstack.getOrCreateTag().getDouble("darksteelReach") > 0) {
					tooltip.add(Component.literal(((itemstack.getOrCreateTag().getDouble("darksteelReach") * (-1) < 0 ? " \u00A7c" : " \u00A72+") + ""
							+ new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("darksteelReach") * (-1)) + " " + Component.translatable("item.the_deep_void.weapon_tooltip.attack_reach").getString())));
				}
				if (itemstack.getOrCreateTag().getDouble("rotLevel") > 0) {
					tooltip.add(
							Component.literal((" \u00A72" + Component.translatable("item.the_deep_void.weapon_tooltip.applies_rot").getString() + " (Lvl " + new java.text.DecimalFormat("##").format(itemstack.getOrCreateTag().getDouble("rotLevel"))
									+ " [00:0" + new java.text.DecimalFormat("##").format(Math.round(itemstack.getOrCreateTag().getDouble("rotDuration") / 20)) + "])")));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BLOODSTONE_ARMOR_BOOTS.get()
				&& itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:claws")))) {
			tooltip.add(Component.literal(""));
			tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.the_deep_void.weapon_tooltip.bloodstone_armor").getString())));
			tooltip.add(Component
					.literal((" \u00A72+" + new java.text.DecimalFormat("##").format((double) DeepVoidConfigConfiguration.BLOODSTONEARMORBONUS.get()) + " " + Component.translatable("item.the_deep_void.weapon_tooltip.attack_damage").getString())));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.PLAGUE_DOCTOR_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.PLAGUE_DOCTOR_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.PLAGUE_DOCTOR_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.PLAGUE_DOCTOR_BOOTS.get()
				&& itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:scythes")))) {
			tooltip.add(Component.literal(""));
			tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.the_deep_void.weapon_tooltip.bloodstone_armor").getString())));
			tooltip.add(Component
					.literal((" \u00A72+" + new java.text.DecimalFormat("##").format((double) DeepVoidConfigConfiguration.PLAGUEARMORBONUS.get()) + " " + Component.translatable("item.the_deep_void.weapon_tooltip.attack_damage").getString())));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_BOOTS.get()
				&& itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:scythes")))) {
			tooltip.add(Component.literal(""));
			tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.the_deep_void.weapon_tooltip.bloodstone_armor").getString())));
			tooltip.add(Component
					.literal((" \u00A72+" + new java.text.DecimalFormat("##").format((double) DeepVoidConfigConfiguration.GRIMROTTENARMORBONUS.get()) + " " + Component.translatable("item.the_deep_void.weapon_tooltip.attack_damage").getString())));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.HUNTERS_BOOTS.get()
				&& itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:claws")))) {
			tooltip.add(Component.literal(""));
			tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.the_deep_void.weapon_tooltip.bloodstone_armor").getString())));
			tooltip.add(Component
					.literal((" \u00A72+" + new java.text.DecimalFormat("##").format((double) DeepVoidConfigConfiguration.HUNTERARMORBONUS.get()) + " " + Component.translatable("item.the_deep_void.weapon_tooltip.attack_damage").getString())));
		}
	}
}
