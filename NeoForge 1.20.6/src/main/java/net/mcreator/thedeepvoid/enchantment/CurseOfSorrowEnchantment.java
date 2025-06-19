
package net.mcreator.thedeepvoid.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class CurseOfSorrowEnchantment extends Enchantment {
	public CurseOfSorrowEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.ARMOR_ENCHANTABLE, 1, 1, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 8, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isCurse() {
		return true;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
