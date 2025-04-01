
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

public class DevourerShieldItem extends ShieldItem {
	public DevourerShieldItem() {
		super(new Item.Properties().durability(540).fireResistant());
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient
				.of(new ItemStack(TheDeepVoidModBlocks.FLESH_BLOCK.get()), new ItemStack(TheDeepVoidModBlocks.PUSTULENT_FLESH_BLOCK.get()), new ItemStack(TheDeepVoidModBlocks.TENDRILS.get()), new ItemStack(TheDeepVoidModItems.DEVOURER_TENDRIL.get()))
				.test(repairitem);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A79Brings all foes near the wielder when held up"));
	}
}
