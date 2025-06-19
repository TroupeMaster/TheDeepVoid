package net.minecraft.world.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BowlFoodItem extends Item {
    public BowlFoodItem(Item.Properties p_40682_) {
        super(p_40682_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack p_40684_, Level p_40685_, LivingEntity p_40686_) {
        ItemStack itemstack = super.finishUsingItem(p_40684_, p_40685_, p_40686_);
        if (p_40686_ instanceof Player player && player.hasInfiniteMaterials()) {
            return itemstack;
        }

        return new ItemStack(Items.BOWL);
    }
}
