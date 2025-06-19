
package net.mcreator.thedeepvoid.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class DarkmareItem extends RecordItem {
	public DarkmareItem() {
		super(7, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:darkmare")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 3620);
	}
}
