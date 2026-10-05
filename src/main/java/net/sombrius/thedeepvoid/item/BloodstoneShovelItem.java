
package net.sombrius.thedeepvoid.item;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class BloodstoneShovelItem extends ShovelItem {
	public BloodstoneShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 2400;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 3.5f;
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
		}, 1, -2.8f, new Item.Properties());
	}
}
