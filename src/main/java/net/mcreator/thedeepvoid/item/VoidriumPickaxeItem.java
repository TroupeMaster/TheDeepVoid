
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.thedeepvoid.procedures.VoidriumSwordLivingEntityIsHitWithToolProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

public class VoidriumPickaxeItem extends PickaxeItem {
	public VoidriumPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 3461;
			}

			public float getSpeed() {
				return 34f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheDeepVoidModItems.VOIDRIUM_GEM.get()));
			}
		}, 1, -2.8f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		VoidriumSwordLivingEntityIsHitWithToolProcedure.execute(entity);
		return retval;
	}
}
