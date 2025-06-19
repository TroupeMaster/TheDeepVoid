package net.minecraft.world.item.enchantment;

public class SoulSpeedEnchantment extends Enchantment {
    public SoulSpeedEnchantment(Enchantment.EnchantmentDefinition p_335817_) {
        super(p_335817_);
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
