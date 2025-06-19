
package net.mcreator.thedeepvoid.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class VoidVisionEnchantment extends Enchantment {
	public VoidVisionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.DURABILITY_ENCHANTABLE, 1, 1, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 8, EquipmentSlot.values()));
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(Items.SPYGLASS)).test(itemstack);
	}

	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
