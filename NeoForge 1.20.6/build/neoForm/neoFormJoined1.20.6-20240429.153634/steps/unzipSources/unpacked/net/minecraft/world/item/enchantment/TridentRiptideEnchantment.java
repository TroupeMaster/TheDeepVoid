package net.minecraft.world.item.enchantment;

public class TridentRiptideEnchantment extends Enchantment {
    public TridentRiptideEnchantment(Enchantment.EnchantmentDefinition p_335985_) {
        super(p_335985_);
    }

    @Override
    public boolean checkCompatibility(Enchantment p_45256_) {
        return super.checkCompatibility(p_45256_) && p_45256_ != Enchantments.LOYALTY && p_45256_ != Enchantments.CHANNELING;
    }
}
