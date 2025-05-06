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
public class ArmorTooltipsProcedure {
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
		if (itemstack.getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ROTTEN_BONE_ARMOR_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal(" "));
					tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
					tooltip.add(Component.literal(" \u00A79-Makes the wearer invisible. When in this state, speed is increased. Upon attacking a foe, the effect ends and double damage is dealt."));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.ONYX_ARMOR_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.ONYX_ARMOR_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.ONYX_ARMOR_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.ONYX_ARMOR_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ONYX_ARMOR_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ONYX_ARMOR_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ONYX_ARMOR_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ONYX_ARMOR_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When in darkness:"));
					tooltip.add(Component.literal(" \u00A79-Attacks get repeated with half the damage"));
					tooltip.add(Component.literal(" \u00A79-Allows the wearer to see in darkness"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_ROTTEN_BONE_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
					tooltip.add(Component.literal(" \u00A79-Makes the wearer invisible. When in this state, speed is increased. Upon attacking a foe, the effect ends and double damage is dealt."));
					tooltip.add(Component.literal("\u00A77When in darkness or when under the effects of Rotten Heart:"));
					tooltip.add(Component.literal(" \u00A79-The armor becomes harder"));
					tooltip.add(Component.literal("\u00A77Upon killing an entity:"));
					tooltip.add(Component.literal(" \u00A79-Resets the cooldown"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.LAVENDITE_ARMOR_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When attacked:"));
					tooltip.add(Component.literal(" \u00A79-Deflects any projectile"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_LAVENDITE_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When attacked:"));
					tooltip.add(Component.literal(" \u00A79-Deflects any projectile back at the shooter"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.BISMUTH_NETHERITE_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When worn:"));
					tooltip.add(Component.literal(" \u00A79-XP heals the wearer"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_HELMET.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When in darkness:"));
				tooltip.add(Component.literal(" \u00A79-Allows the wearer to see in darkness"));
			} else {
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_HELMET.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_CHESTPLATE.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_LEGGINGS.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_BOOTS.get())
						&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_HELMET.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_CHESTPLATE.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_LEGGINGS.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_BOOTS.get())) {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_LEGGINGS.get() || itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_LEGGINGS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When in darkness:"));
				tooltip.add(Component.literal(" \u00A79-The wearer can run faster"));
			} else {
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_HELMET.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_CHESTPLATE.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_LEGGINGS.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_BOOTS.get())
						&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_HELMET.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_CHESTPLATE.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_LEGGINGS.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_BOOTS.get())) {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_BOOTS.get() || itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_BOOTS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When worn:"));
				tooltip.add(Component.literal(" \u00A79-Negates fall damage"));
			} else {
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_HELMET.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_CHESTPLATE.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_LEGGINGS.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_BOOTS.get())
						&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_HELMET.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_CHESTPLATE.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_LEGGINGS.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_BOOTS.get())) {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_CHESTPLATE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When at half health:"));
				tooltip.add(Component.literal(" \u00A79-The wearer is granted Resistance and Strength"));
			} else {
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_HELMET.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_CHESTPLATE.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_LEGGINGS.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_BOOTS.get())
						&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_HELMET.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_CHESTPLATE.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_LEGGINGS.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_BOOTS.get())) {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.VOIDRIUM_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.VOIDRIUM_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When worn:"));
					tooltip.add(Component.literal(" \u00A79-Has a chance to repeat the damage, divided by half, dealt"));
					tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
					tooltip.add(Component.literal(" \u00A79-Teleports the wearer"));
					tooltip.add(Component.literal("\u00A77When attacked:"));
					tooltip.add(Component.literal(" \u00A79-Damages the attacker"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.VOID_CLOAK_CHESTPLATE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
				tooltip.add(Component.literal(" \u00A79-Allows the wearer to phase through walls"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.FLESH_ARMOR_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.FLESH_ARMOR_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.FLESH_ARMOR_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.FLESH_ARMOR_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.FLESH_ARMOR_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.FLESH_ARMOR_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.FLESH_ARMOR_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.FLESH_ARMOR_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When attacked:"));
					tooltip.add(Component.literal(" \u00A79-The armor becomes more resilient and heavier"));
					tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
					tooltip.add(Component.literal(" \u00A79-Unleashes a devastating roar that damages every entity around the wearer based on the resilience of the armor"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.ALL_SEEING_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.ALL_SEEING_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.ALL_SEEING_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.ALL_SEEING_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ALL_SEEING_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When entity targets the wearer:"));
					tooltip.add(Component.literal(" \u00A79-The entity is given the glowing effect"));
					tooltip.add(Component.literal(" \u00A79-The wearer gets empowered with strength"));
					tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
					tooltip.add(Component.literal(" \u00A79-Allows the wearer to multiply their velocity"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.CRAWLER_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.CRAWLER_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.CRAWLER_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.CRAWLER_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When worn:"));
					tooltip.add(Component.literal(" \u00A79-Immunity to Rot"));
					tooltip.add(Component.literal(" \u00A79-The wearer becomes invisible, faster and more resistant on bone blocks"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.GRIM_CRAWLER_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.CRAWLER_CHESTPLATE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
				tooltip.add(Component.literal(" \u00A79-The wearer can slow fall"));
			} else {
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_HELMET.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_CHESTPLATE.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_LEGGINGS.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_BOOTS.get())
						&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_HELMET.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_CHESTPLATE.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_LEGGINGS.get()
								&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CRAWLER_BOOTS.get())) {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.GRIM_CRAWLER_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.GRIM_CRAWLER_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.GRIM_CRAWLER_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.GRIM_CRAWLER_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.GRIM_CRAWLER_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When worn:"));
					tooltip.add(Component.literal(" \u00A79-Immunity to Rot"));
					tooltip.add(Component.literal(" \u00A79-The wearer becomes invisible, faster and more resistant on bone blocks"));
					tooltip.add(Component.literal("\u00A77When in darkness:"));
					tooltip.add(Component.literal(" \u00A79-All attacks inflict Rot I"));
					tooltip.add(Component.literal(" \u00A79-Allows the wearer to see in darkness"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.CULT_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.CULT_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.CULT_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.CULT_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CULT_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CULT_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CULT_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CULT_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When worn:"));
					tooltip.add(Component.literal(" \u00A79-Grants Void's Blessing"));
					tooltip.add(Component.literal(" \u00A79-The wearer runs faster"));
					tooltip.add(Component.literal(" \u00A79-Light damages the wearer"));
					tooltip.add(Component.literal("\u00A77When attacked:"));
					tooltip.add(Component.literal(" \u00A79-Doubles any damage received"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When worn:"));
				tooltip.add(Component.literal(" \u00A79-Built Overseers around the wearer are empowered"));
				tooltip.add(Component.literal(" \u00A79-The wearer can no longer heal naturally, only Regeneration, Instant Health and Golden Blood can heal health"));
				tooltip.add(Component.literal("\u00A77When killing a foe:"));
				tooltip.add(Component.literal(" \u00A79-The wearer's health is enhanced until death or the mask is removed. This has a limit and when reached, the wearer will instead get strength and speed temporarily"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When attacking:"));
				tooltip.add(Component.literal(" \u00A79-Each 6 hit, the wearer is teleported behind the foe and given Regeneration II for 7 seconds"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77When attacked:"));
				tooltip.add(Component.literal(" \u00A79-The wearer has a chance to dodge the attack"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A77On No Gravity key pressed:"));
				tooltip.add(Component.literal(" \u00A79-Allows the wearer to walk on air if there are no solid blocks underneath"));
				tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
				tooltip.add(Component.literal(" \u00A79-The wearer will dash where they're facing"));
			} else {
				tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get()) {
			if (itemstack.getItem() == TheDeepVoidModItems.WEAVER_MASK_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.WEAVER_ROBE_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.WEAVER_LEGGINGS_LEGGINGS.get()
					|| itemstack.getItem() == TheDeepVoidModItems.WEAVER_BOOTS_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77Full Armor:"));
					tooltip.add(Component.literal(" \u00A79-Slowly withers away the soul of nearby victims"));
				}
			}
		}
		if (itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_HELMET.get() || itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_CHESTPLATE.get() || itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_LEGGINGS.get()
				|| itemstack.getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.SACRED_VOIDRIUM_BOOTS.get()) {
				if (Screen.hasShiftDown()) {
					tooltip.add(Component.literal("\u00A77When worn:"));
					tooltip.add(Component.literal(" \u00A79-Has a higher chance to repeat the damage, divided by half, dealt"));
					tooltip.add(Component.literal("\u00A77On Armor Ability key pressed:"));
					tooltip.add(Component.literal(" \u00A79-Teleports the wearer, damaging the very soul of victims they pass through, applying Hexed I and giving Regeneration I"));
					tooltip.add(Component.literal("\u00A77When attacked:"));
					tooltip.add(Component.literal(" \u00A79-Damages the attacker"));
					tooltip.add(Component.literal(" \u00A79-Summons Shadow Hands to attack"));
				} else {
					tooltip.add(Component.literal("\u00A76Press Shift to show abilities"));
				}
			}
		}
	}
}
