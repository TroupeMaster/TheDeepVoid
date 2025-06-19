package net.minecraft.world.item.enchantment;

public class UntouchingEnchantment extends Enchantment {
    protected UntouchingEnchantment(Enchantment.EnchantmentDefinition p_336087_) {
        super(p_336087_);
    }

    @Override
    public boolean checkCompatibility(Enchantment p_45266_) {
        return super.checkCompatibility(p_45266_) && p_45266_ != Enchantments.FORTUNE;
    }
}
