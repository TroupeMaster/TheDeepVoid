
package net.sombrius.thedeepvoid.item;

import net.sombrius.thedeepvoid.init.TheDeepVoidModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class LiquidIchorItem extends BucketItem {
	public LiquidIchorItem() {
		super(TheDeepVoidModFluids.LIQUID_ICHOR, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
