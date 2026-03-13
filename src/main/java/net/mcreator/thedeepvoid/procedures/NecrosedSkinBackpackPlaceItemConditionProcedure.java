package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class NecrosedSkinBackpackPlaceItemConditionProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:containers")))) {
			return true;
		}
		return false;
	}
}
