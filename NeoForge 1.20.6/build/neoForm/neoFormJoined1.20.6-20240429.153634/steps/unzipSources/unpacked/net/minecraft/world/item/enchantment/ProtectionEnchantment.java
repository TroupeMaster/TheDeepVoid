package net.minecraft.world.item.enchantment;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class ProtectionEnchantment extends Enchantment {
    public final ProtectionEnchantment.Type type;

    public ProtectionEnchantment(Enchantment.EnchantmentDefinition p_335937_, ProtectionEnchantment.Type p_45127_) {
        super(p_335937_);
        this.type = p_45127_;
    }

    @Override
    public int getDamageProtection(int p_45133_, DamageSource p_45134_) {
        if (p_45134_.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return 0;
        } else if (this.type == ProtectionEnchantment.Type.ALL) {
            return p_45133_;
        } else if (this.type == ProtectionEnchantment.Type.FIRE && p_45134_.is(DamageTypeTags.IS_FIRE)) {
            return p_45133_ * 2;
        } else if (this.type == ProtectionEnchantment.Type.FALL && p_45134_.is(DamageTypeTags.IS_FALL)) {
            return p_45133_ * 3;
        } else if (this.type == ProtectionEnchantment.Type.EXPLOSION && p_45134_.is(DamageTypeTags.IS_EXPLOSION)) {
            return p_45133_ * 2;
        } else {
            return this.type == ProtectionEnchantment.Type.PROJECTILE && p_45134_.is(DamageTypeTags.IS_PROJECTILE) ? p_45133_ * 2 : 0;
        }
    }

    @Override
    public boolean checkCompatibility(Enchantment p_45142_) {
        if (p_45142_ instanceof ProtectionEnchantment protectionenchantment) {
            return this.type == protectionenchantment.type
                ? false
                : this.type == ProtectionEnchantment.Type.FALL || protectionenchantment.type == ProtectionEnchantment.Type.FALL;
        } else {
            return super.checkCompatibility(p_45142_);
        }
    }

    public static int getFireAfterDampener(LivingEntity p_45139_, int p_45140_) {
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_PROTECTION, p_45139_);
        if (i > 0) {
            p_45140_ -= Mth.floor((float)p_45140_ * (float)i * 0.15F);
        }

        return p_45140_;
    }

    public static double getExplosionKnockbackAfterDampener(LivingEntity p_45136_, double p_45137_) {
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.BLAST_PROTECTION, p_45136_);
        if (i > 0) {
            p_45137_ *= Mth.clamp(1.0 - (double)i * 0.15, 0.0, 1.0);
        }

        return p_45137_;
    }

    public static enum Type {
        ALL,
        FIRE,
        FALL,
        EXPLOSION,
        PROJECTILE;
    }
}
