package net.minecraft.world.item.crafting;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;

public class ArmorDyeRecipe extends CustomRecipe {
    public ArmorDyeRecipe(CraftingBookCategory p_251949_) {
        super(p_251949_);
    }

    public boolean matches(CraftingContainer p_43769_, Level p_43770_) {
        ItemStack itemstack = ItemStack.EMPTY;
        List<ItemStack> list = Lists.newArrayList();

        for (int i = 0; i < p_43769_.getContainerSize(); i++) {
            ItemStack itemstack1 = p_43769_.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.is(ItemTags.DYEABLE)) {
                    if (!itemstack.isEmpty()) {
                        return false;
                    }

                    itemstack = itemstack1;
                } else {
                    if (!(itemstack1.getItem() instanceof DyeItem)) {
                        return false;
                    }

                    list.add(itemstack1);
                }
            }
        }

        return !itemstack.isEmpty() && !list.isEmpty();
    }

    public ItemStack assemble(CraftingContainer p_43767_, HolderLookup.Provider p_335722_) {
        List<DyeItem> list = Lists.newArrayList();
        ItemStack itemstack = ItemStack.EMPTY;

        for (int i = 0; i < p_43767_.getContainerSize(); i++) {
            ItemStack itemstack1 = p_43767_.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.is(ItemTags.DYEABLE)) {
                    if (!itemstack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }

                    itemstack = itemstack1.copy();
                } else {
                    if (!(itemstack1.getItem() instanceof DyeItem dyeitem)) {
                        return ItemStack.EMPTY;
                    }

                    list.add(dyeitem);
                }
            }
        }

        return !itemstack.isEmpty() && !list.isEmpty() ? DyedItemColor.applyDyes(itemstack, list) : ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_43759_, int p_43760_) {
        return p_43759_ * p_43760_ >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.ARMOR_DYE;
    }
}
