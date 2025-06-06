
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class BismuthNetheriteShovelItem extends ShovelItem {
	public BismuthNetheriteShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 2464;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 5.5f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT), new ItemStack(TheDeepVoidModItems.REFINED_BISMUTH.get()));
			}
		}, 1, -3f, new Item.Properties().fireResistant());
	}
}
