
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ScavengerArmorTrimItem extends Item {
	public ScavengerArmorTrimItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Scavenger Armor Trim"));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A77Applies to:"));
		list.add(Component.literal(" \u00A79Armor"));
		list.add(Component.literal("\u00A77Ingredients:"));
		list.add(Component.literal(" \u00A79Ingot & Crystals"));
	}
}
