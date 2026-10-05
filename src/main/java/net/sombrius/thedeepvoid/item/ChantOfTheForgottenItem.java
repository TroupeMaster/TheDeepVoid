
package net.sombrius.thedeepvoid.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class ChantOfTheForgottenItem extends RecordItem {
	public ChantOfTheForgottenItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_sing_mono")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 820);
	}
}
