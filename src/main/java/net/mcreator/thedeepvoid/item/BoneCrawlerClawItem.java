
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

import net.mcreator.thedeepvoid.procedures.BoneCrawlerClawLivingEntityIsHitWithToolProcedure;
import net.mcreator.thedeepvoid.procedures.BoneCrawlerClawDescriptionProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;

import java.util.List;

public class BoneCrawlerClawItem extends SwordItem {
	public BoneCrawlerClawItem() {
		super(new Tier() {
			public int getUses() {
				return 850;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheDeepVoidModItems.ROTTEN_BONE.get()));
			}
		}, 3, -1.5f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		BoneCrawlerClawLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity, sourceentity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		list.add(Component.literal(BoneCrawlerClawDescriptionProcedure.execute()));
	}
}
