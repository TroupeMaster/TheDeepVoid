
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlessedPearlItem extends Item {
	public BlessedPearlItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
