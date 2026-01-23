
package net.mcreator.thedeepvoid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.thedeepvoid.procedures.MistedHeartLivingEntityIsHitWithItemProcedure;

public class MistedHeartItem extends Item {
	public MistedHeartItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		MistedHeartLivingEntityIsHitWithItemProcedure.execute(entity, sourceentity);
		return retval;
	}
}
