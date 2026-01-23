
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

import net.mcreator.thedeepvoid.procedures.TheBonkLivingEntityIsHitWithToolProcedure;

import java.util.List;

public class TheBonkItem extends SwordItem {
	public TheBonkItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 99f;
			}

			public float getAttackDamageBonus() {
				return 995f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 99;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 3, 95f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TheBonkLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7bCreative mode only"));
		list.add(Component.literal(" \u00A79Removes boss spawns completely (hive's brain, eye of the watcher, giant bone crawler egg)"));
	}
}
