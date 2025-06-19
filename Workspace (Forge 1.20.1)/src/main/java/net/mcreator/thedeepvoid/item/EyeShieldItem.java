
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

import java.util.List;

public class EyeShieldItem extends ShieldItem {
	public EyeShieldItem() {
		super(new Item.Properties().durability(1561));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(TheDeepVoidModItems.VOID_LENS.get()), new ItemStack(TheDeepVoidModItems.GRIM_GEM.get()), new ItemStack(TheDeepVoidModItems.ONYX.get()), new ItemStack(TheDeepVoidModBlocks.DESOLATE_SOIL.get()))
				.test(repairitem);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Paralizes every foe in front of the wielder when blocking an attack"));
	}
}
