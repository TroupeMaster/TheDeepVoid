package net.minecraft.world.item.enchantment;

public class ArrowInfiniteEnchantment extends Enchantment {
    public ArrowInfiniteEnchantment(Enchantment.EnchantmentDefinition p_336014_) {
        super(p_336014_);
    }

    @Override
    public boolean checkCompatibility(Enchantment p_44590_) {
        return p_44590_ instanceof MendingEnchantment ? false : super.checkCompatibility(p_44590_);
    }
}
