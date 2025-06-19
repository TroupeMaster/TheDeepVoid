package net.minecraft.world.item.enchantment;

public class MendingEnchantment extends Enchantment {
    public MendingEnchantment(Enchantment.EnchantmentDefinition p_336099_) {
        super(p_336099_);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
