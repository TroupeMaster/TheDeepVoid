
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CrawlerOmeletteItem extends Item {
	public CrawlerOmeletteItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(20).saturationModifier(8f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 64;
	}
}
