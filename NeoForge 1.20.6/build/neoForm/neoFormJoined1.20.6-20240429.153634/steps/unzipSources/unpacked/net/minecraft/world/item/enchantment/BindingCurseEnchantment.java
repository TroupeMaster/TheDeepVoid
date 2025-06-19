package net.minecraft.world.item.enchantment;

public class BindingCurseEnchantment extends Enchantment {
    public BindingCurseEnchantment(Enchantment.EnchantmentDefinition p_335394_) {
        super(p_335394_);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }
}
