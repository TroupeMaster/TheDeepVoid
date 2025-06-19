
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class LurkingMusicDiscItem extends RecordItem {
	public LurkingMusicDiscItem() {
		super(8, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:lurking_monst3r_music")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 4500);
	}
}
