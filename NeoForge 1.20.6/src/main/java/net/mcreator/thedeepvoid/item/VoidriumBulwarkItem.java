
package net.mcreator.thedeepvoid.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.procedures.VoidriumBulwarkToolInInventoryTickProcedure;
import net.mcreator.thedeepvoid.procedures.VoidriumBulwarkRightclickedProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import java.util.List;

public class VoidriumBulwarkItem extends ShieldItem {
	public VoidriumBulwarkItem() {
		super(new Item.Properties().durability(3461).fireResistant());
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(TheDeepVoidModItems.VOIDRIUM_GEM.get())).test(repairitem);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		VoidriumBulwarkRightclickedProcedure.execute(ar.getObject());
		return ar;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A79The Deep Void"));
		list.add(Component.literal("\u00A77Enemies that hit the shield take damage"));
		list.add(Component.literal("\u00A77Right click at the right moment to parry an attack, gaining Strength II for a short time and stunning foes"));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A77When in Main Hand:"));
		list.add(Component.literal(" \u00A72 4 Attack Damage"));
		list.add(Component.literal(" \u00A72 4 Attack Speed"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		VoidriumBulwarkToolInInventoryTickProcedure.execute(itemstack);
	}
}
