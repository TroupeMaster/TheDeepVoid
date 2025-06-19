
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.procedures.TombstoneToolInInventoryTickProcedure;
import net.mcreator.thedeepvoid.procedures.TombstoneLivingEntityIsHitWithToolProcedure;
import net.mcreator.thedeepvoid.procedures.TombstoneInHandTickProcedure;

import java.util.List;

public class TombstoneItem extends SwordItem {
	public TombstoneItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 14f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, -3.2f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TombstoneLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77A tombstone with a 3 hit combo. When the wielder successfully performs the combo, all mobs around the target including itself will be inflicted with Doom."));
		list.add(Component.literal("\u00A77When a victim is Doomed, a tombstone will fall on their head, dealing 25% of their health in damage."));
		list.add(Component.literal("\u00A77The Tombstone needs to be almost fully charged in order to deal damage."));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			TombstoneInHandTickProcedure.execute(entity, itemstack);
		TombstoneToolInInventoryTickProcedure.execute(itemstack);
	}
}
