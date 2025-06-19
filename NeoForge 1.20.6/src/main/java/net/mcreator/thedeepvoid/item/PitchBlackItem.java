
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class PitchBlackItem extends RecordItem {
	public PitchBlackItem() {
		super(8, () -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:pitch_black")), new Item.Properties().stacksTo(1).rarity(Rarity.COMMON), 1780);
	}
}
