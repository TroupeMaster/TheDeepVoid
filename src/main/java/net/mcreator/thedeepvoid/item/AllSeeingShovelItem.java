
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class AllSeeingShovelItem extends ShovelItem {
	public AllSeeingShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 460;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 3.5f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheDeepVoidModItems.REFINED_CINNABAR.get()));
			}
		}, 1, -3f, new Item.Properties().fireResistant());
	}
}
