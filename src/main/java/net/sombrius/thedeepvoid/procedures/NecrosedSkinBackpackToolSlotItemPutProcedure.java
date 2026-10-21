package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class NecrosedSkinBackpackToolSlotItemPutProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getItem() instanceof SwordItem || itemstack.getItem() instanceof PickaxeItem || itemstack.getItem() instanceof AxeItem || itemstack.getItem() instanceof ShovelItem || itemstack.getItem() instanceof HoeItem
				|| itemstack.getItem() instanceof BowItem || itemstack.getItem() instanceof CrossbowItem || itemstack.getItem() instanceof ShieldItem || itemstack.getItem() instanceof TridentItem
				|| itemstack.is(ItemTags.create(new ResourceLocation("the_deep_void:backpack_tools")))) {
			return false;
		}
		return true;
	}
}
