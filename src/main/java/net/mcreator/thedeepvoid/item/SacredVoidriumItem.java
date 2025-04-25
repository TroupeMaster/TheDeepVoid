
package net.mcreator.thedeepvoid.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.procedures.VoidriumLeggingsTickEventProcedure;
import net.mcreator.thedeepvoid.procedures.VoidriumHelmetTickEventProcedure;
import net.mcreator.thedeepvoid.procedures.VoidriumChestplateTickEventProcedure;

import com.google.common.collect.Iterables;

public abstract class SacredVoidriumItem extends ArmorItem {
	public SacredVoidriumItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 0;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{8, 10, 12, 8}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 24;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}

			@Override
			public String getName() {
				return "sacred_voidrium";
			}

			@Override
			public float getToughness() {
				return 4.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.4f;
			}
		}, type, properties);
	}

	public static class Helmet extends SacredVoidriumItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "the_deep_void:textures/models/armor/soulfused_voidrium__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				VoidriumHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
			}
		}
	}

	public static class Chestplate extends SacredVoidriumItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "the_deep_void:textures/models/armor/soulfused_voidrium__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				VoidriumChestplateTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends SacredVoidriumItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "the_deep_void:textures/models/armor/soulfused_voidrium__layer_2.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				VoidriumLeggingsTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
			}
		}
	}

	public static class Boots extends SacredVoidriumItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "the_deep_void:textures/models/armor/soulfused_voidrium__layer_1.png";
		}
	}
}
