
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

import net.mcreator.thedeepvoid.procedures.BloodthirstyClawsEntitySwingsItemProcedure;
import net.mcreator.thedeepvoid.procedures.BloodthirstyClawsDescriptionProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import java.util.List;

public class BloodthirstyClawsItem extends SwordItem {
	public BloodthirstyClawsItem() {
		super(new Tier() {
			public int getUses() {
				return 2400;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 8;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheDeepVoidModItems.BLOODSTONE.get()));
			}
		}, 3, -1.4f, new Item.Properties().fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		list.add(Component.literal(BloodthirstyClawsDescriptionProcedure.execute()));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		BloodthirstyClawsEntitySwingsItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}
}
