
package net.mcreator.thedeepvoid.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MonstersLairItem extends RecordItem {
	public MonstersLairItem() {
		super(8, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:monsters_lair")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 3600);
	}
}
