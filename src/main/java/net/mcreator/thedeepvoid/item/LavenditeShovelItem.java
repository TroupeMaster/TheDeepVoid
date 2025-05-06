
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class LavenditeShovelItem extends ShovelItem {
	public LavenditeShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 12;
			}

			public float getSpeed() {
				return 60f;
			}

			public float getAttackDamageBonus() {
				return 3.5f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheDeepVoidModItems.LAVENDITE.get()));
			}
		}, 1, -1f, new Item.Properties());
	}
}
