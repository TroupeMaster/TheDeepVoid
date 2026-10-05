
package net.sombrius.thedeepvoid.item;

import net.sombrius.thedeepvoid.procedures.BismuthVialRightclickedProcedure;
import net.sombrius.thedeepvoid.procedures.BismuthVialHasItemGlowingEffectProcedure;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class BismuthVialItem extends Item {
	public BismuthVialItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return BismuthVialHasItemGlowingEffectProcedure.execute(itemstack);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BismuthVialRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}
