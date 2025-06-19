
package net.mcreator.thedeepvoid.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;

public class BoneWalkerEnchantment extends Enchantment {
	public BoneWalkerEnchantment(EquipmentSlot... slots) {
		super(Enchantment.definition(ItemTags.FOOT_ARMOR_ENCHANTABLE, 10, 3, Enchantment.dynamicCost(1, 10), Enchantment.dynamicCost(6, 10), 1, EquipmentSlot.FEET));
	}
}
