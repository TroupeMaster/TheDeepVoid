
package net.mcreator.thedeepvoid.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class SinsAndSinnersItem extends RecordItem {
	public SinsAndSinnersItem() {
		super(7, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sins_and_sinners")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 3300);
	}
}
