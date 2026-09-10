
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IchorFlareItem extends Item {
	public IchorFlareItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
