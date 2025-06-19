package net.minecraft.world.item.enchantment;

public class SwiftSneakEnchantment extends Enchantment {
    public SwiftSneakEnchantment(Enchantment.EnchantmentDefinition p_336085_) {
        super(p_336085_);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }
}
