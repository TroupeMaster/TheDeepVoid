package net.minecraft.world.item.enchantment;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class DigDurabilityEnchantment extends Enchantment {
    protected DigDurabilityEnchantment(Enchantment.EnchantmentDefinition p_335611_) {
        super(p_335611_);
    }

    public static boolean shouldIgnoreDurabilityDrop(ItemStack p_220283_, int p_220284_, RandomSource p_220285_) {
        return p_220283_.getItem() instanceof ArmorItem && p_220285_.nextFloat() < 0.6F ? false : p_220285_.nextInt(p_220284_ + 1) > 0;
    }
}
