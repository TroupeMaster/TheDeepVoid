
package net.mcreator.thedeepvoid.enchantment;

import net.neoforged.neoforge.common.crafting.CompoundIngredient;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class ScourgeOfFleshEnchantment extends Enchantment {
	public ScourgeOfFleshEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.WEAPON_ENCHANTABLE, 2, 5, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 4, EquipmentSlot.MAINHAND));
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return this != enchantment && !List.of(Enchantments.BANE_OF_ARTHROPODS, Enchantments.SMITE, Enchantments.SHARPNESS).contains(enchantment);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return CompoundIngredient.of(Ingredient.of(ItemTags.create(new ResourceLocation("minecraft:axes"))), Ingredient.of(ItemTags.create(new ResourceLocation("minecraft:swords")))).test(itemstack);
	}
}
