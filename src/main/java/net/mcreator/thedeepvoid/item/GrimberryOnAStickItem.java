
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.thedeepvoid.procedures.GrimberryOnAStickRightclickedProcedure;
import net.mcreator.thedeepvoid.procedures.GrimberryOnAStickItemInInventoryTickProcedure;

public class GrimberryOnAStickItem extends Item {
	public GrimberryOnAStickItem() {
		super(new Item.Properties().durability(35).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GrimberryOnAStickRightclickedProcedure.execute(entity, ar.getObject());
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GrimberryOnAStickItemInInventoryTickProcedure.execute(entity, itemstack);
	}
}
