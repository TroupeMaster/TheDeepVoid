
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class LavenditeHoeItem extends HoeItem {
	public LavenditeHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 12;
			}

			public float getSpeed() {
				return 60f;
			}

			public float getAttackDamageBonus() {
				return 0f;
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
		}, 0, -1f, new Item.Properties());
	}
}
