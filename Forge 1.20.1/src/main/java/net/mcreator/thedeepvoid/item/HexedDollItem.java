
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.procedures.HexedDollRightclickedOnBlockProcedure;

import java.util.List;

public class HexedDollItem extends Item {
	public HexedDollItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A79Right click on a Soul Container to summon the Weaver Of Souls"));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A79Right click on a Soul Forge to summon the Apostle Of Catastrophe, breaking the Soul Forge in the process"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		HexedDollRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
