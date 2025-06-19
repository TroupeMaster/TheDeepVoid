
package net.mcreator.thedeepvoid.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.procedures.CreepOMeterRightclickedProcedure;
import net.mcreator.thedeepvoid.procedures.CreepOMeterItemInHandTickProcedure;

import java.util.List;

public class CreepOMeterItem extends Item {
	public CreepOMeterItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7bCreative mode only"));
		list.add(Component.literal("\u00A79Shows the spawn timer for the Stalker/Nightmare"));
		list.add(Component.literal(" \u00A79-Stalker is above y=0 and Nightmare below"));
		list.add(Component.literal(" \u00A79-Right click to show the Stalking Stalker/Darkness count instead"));
		list.add(Component.literal(" \u00A79-Right click while sneaking to show if the Stalker is after you above y=0 or the Darkness Damage Build Up below y=0"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		CreepOMeterRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			CreepOMeterItemInHandTickProcedure.execute(entity.getY(), entity, itemstack);
	}
}
