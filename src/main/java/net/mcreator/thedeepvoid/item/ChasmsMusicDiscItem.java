
package net.mcreator.thedeepvoid.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class ChasmsMusicDiscItem extends RecordItem {
	public ChasmsMusicDiscItem() {
		super(6, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:from_within_monst3r_music")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3840);
	}
}
