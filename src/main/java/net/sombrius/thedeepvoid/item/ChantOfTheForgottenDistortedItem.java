
package net.sombrius.thedeepvoid.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class ChantOfTheForgottenDistortedItem extends RecordItem {
	public ChantOfTheForgottenDistortedItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_sing_distorted")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 820);
	}
}
