
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BismuthItem extends Item {
	public BismuthItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
