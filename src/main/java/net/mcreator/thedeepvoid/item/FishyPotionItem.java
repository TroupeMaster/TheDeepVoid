
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FishyPotionItem extends Item {
	public FishyPotionItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
