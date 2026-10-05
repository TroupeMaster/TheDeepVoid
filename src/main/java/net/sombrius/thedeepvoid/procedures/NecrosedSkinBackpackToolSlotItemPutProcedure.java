package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;

import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.AxeItem;

public class NecrosedSkinBackpackToolSlotItemPutProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getItem() instanceof SwordItem || itemstack.getItem() instanceof PickaxeItem || itemstack.getItem() instanceof AxeItem || itemstack.getItem() instanceof ShovelItem || itemstack.getItem() instanceof HoeItem
				|| itemstack.getItem() instanceof BowItem || itemstack.getItem() instanceof CrossbowItem || itemstack.getItem() instanceof ShieldItem || itemstack.getItem() instanceof TridentItem
				|| itemstack.getItem() == TheDeepVoidModItems.ONYX_FLARE_GUN.get() || itemstack.getItem() == Items.SHEARS || itemstack.getItem() == TheDeepVoidModItems.LICKER_HOOK.get()
				|| itemstack.getItem() == TheDeepVoidModItems.GRIM_LICKER_HOOK.get() || itemstack.getItem() == TheDeepVoidModItems.VENGEFUL_LICKER_HOOK.get() || itemstack.getItem() == TheDeepVoidModItems.BONE_CLIMBING_PICK.get()) {
			return false;
		}
		return true;
	}
}
