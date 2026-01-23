
package net.mcreator.thedeepvoid.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.thedeepvoid.procedures.VoidPendantRightclickedOnBlockProcedure;
import net.mcreator.thedeepvoid.procedures.VoidPendantPlayerFinishesUsingItemProcedure;
import net.mcreator.thedeepvoid.procedures.VoidPendantItemInHandTickProcedure;
import net.mcreator.thedeepvoid.procedures.VoidPendantHasItemGlowingEffectProcedure;

public class VoidPendantItem extends Item {
	public VoidPendantItem() {
		super(new Item.Properties().durability(3).rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return VoidPendantHasItemGlowingEffectProcedure.execute(itemstack);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		VoidPendantPlayerFinishesUsingItemProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		VoidPendantRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			VoidPendantItemInHandTickProcedure.execute(entity, itemstack);
	}
}
