package net.minecraft.world.item.crafting;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;

public class DecoratedPotRecipe extends CustomRecipe {
    public DecoratedPotRecipe(CraftingBookCategory p_273056_) {
        super(p_273056_);
    }

    public boolean matches(CraftingContainer p_272882_, Level p_272812_) {
        if (!this.canCraftInDimensions(p_272882_.getWidth(), p_272882_.getHeight())) {
            return false;
        } else {
            for (int i = 0; i < p_272882_.getContainerSize(); i++) {
                ItemStack itemstack = p_272882_.getItem(i);
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                        if (!itemstack.is(ItemTags.DECORATED_POT_INGREDIENTS)) {
                            return false;
                        }
                        break;
                    case 2:
                    case 4:
                    case 6:
                    default:
                        if (!itemstack.is(Items.AIR)) {
                            return false;
                        }
                }
            }

            return true;
        }
    }

    public ItemStack assemble(CraftingContainer p_272861_, HolderLookup.Provider p_335840_) {
        PotDecorations potdecorations = new PotDecorations(
            p_272861_.getItem(1).getItem(), p_272861_.getItem(3).getItem(), p_272861_.getItem(5).getItem(), p_272861_.getItem(7).getItem()
        );
        return DecoratedPotBlockEntity.createDecoratedPotItem(potdecorations);
    }

    @Override
    public boolean canCraftInDimensions(int p_273734_, int p_273516_) {
        return p_273734_ == 3 && p_273516_ == 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.DECORATED_POT_RECIPE;
    }
}
