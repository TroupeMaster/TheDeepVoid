
package net.sombrius.thedeepvoid.item;

import net.sombrius.thedeepvoid.procedures.SpyglassDummyItemInHandTickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class SpyglassDummyItem extends Item {
	public SpyglassDummyItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			SpyglassDummyItemInHandTickProcedure.execute(entity, itemstack);
	}
}
