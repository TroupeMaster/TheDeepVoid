package net.minecraft.world.item.crafting;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class StonecutterRecipe extends SingleItemRecipe {
    public StonecutterRecipe(String p_44479_, Ingredient p_44480_, ItemStack p_302318_) {
        super(RecipeType.STONECUTTING, RecipeSerializer.STONECUTTER, p_44479_, p_44480_, p_302318_);
    }

    @Override
    public boolean matches(Container p_44483_, Level p_44484_) {
        return this.ingredient.test(p_44483_.getItem(0));
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.STONECUTTER);
    }
}
