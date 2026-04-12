
package net.mcreator.thedeepvoid.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class DimensionalBurstEnchantment extends Enchantment {
	public DimensionalBurstEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.CROSSBOW, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(TheDeepVoidModItems.BLACK_HOLE.get())).test(itemstack);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
