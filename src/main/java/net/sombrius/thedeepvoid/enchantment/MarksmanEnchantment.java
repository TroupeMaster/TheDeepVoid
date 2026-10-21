
package net.sombrius.thedeepvoid.enchantment;

import net.sombrius.thedeepvoid.init.TheDeepVoidModEnchantments;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class MarksmanEnchantment extends Enchantment {
	public MarksmanEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(TheDeepVoidModEnchantments.POINT_BLANK.get(), TheDeepVoidModEnchantments.AKIMBO.get()).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(ItemTags.create(new ResourceLocation("the_deep_void:guns"))).test(itemstack);
	}
}
