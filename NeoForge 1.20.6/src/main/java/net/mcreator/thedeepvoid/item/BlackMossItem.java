
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlackMossItem extends Item {
	public BlackMossItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
