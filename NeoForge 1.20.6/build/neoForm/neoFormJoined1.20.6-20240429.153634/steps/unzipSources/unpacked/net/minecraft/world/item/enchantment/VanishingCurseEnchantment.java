package net.minecraft.world.item.enchantment;

public class VanishingCurseEnchantment extends Enchantment {
    public VanishingCurseEnchantment(Enchantment.EnchantmentDefinition p_335853_) {
        super(p_335853_);
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
