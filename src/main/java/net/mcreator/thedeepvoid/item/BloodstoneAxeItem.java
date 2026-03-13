
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class BloodstoneAxeItem extends AxeItem {
	public BloodstoneAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 2400;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 7f;
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
		}, 1, -2.8f, new Item.Properties().fireResistant());
	}
}
