
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.procedures.TheHarvestRightclickedProcedure;

import java.util.List;

public class TheHarvestItem extends SwordItem {
	public TheHarvestItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 10f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 24;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, -3.2f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TheHarvestRightclickedProcedure.execute(entity.level(), entity, sourceentity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A79Hitting a foe with the scythe will create a soul slash, damaging any mob nearby and giving them the Hexed effect."));
		list.add(Component.literal("\u00A79When attacking a foe that has Hexed, one more level will be added as well as two additional seconds."));
	}
}
