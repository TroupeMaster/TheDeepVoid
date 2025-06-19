
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.thedeepvoid.init.TheDeepVoidModFluids;

public class LiquidVoidItem extends BucketItem {
	public LiquidVoidItem() {
		super(TheDeepVoidModFluids.LIQUID_VOID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
