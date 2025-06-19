
package net.mcreator.thedeepvoid.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class NecrosedEnchantment extends Enchantment {
	public NecrosedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.CHEST_ARMOR_ENCHANTABLE, 2, 4, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 4, EquipmentSlot.CHEST));
	}
}
