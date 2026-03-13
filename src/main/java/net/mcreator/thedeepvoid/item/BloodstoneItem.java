
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BloodstoneItem extends Item {
	public BloodstoneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
