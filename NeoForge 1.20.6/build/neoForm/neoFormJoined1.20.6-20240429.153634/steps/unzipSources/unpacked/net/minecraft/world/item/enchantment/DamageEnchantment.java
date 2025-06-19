package net.minecraft.world.item.enchantment;

import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

public class DamageEnchantment extends Enchantment {
    private final Optional<TagKey<EntityType<?>>> targets;

    public DamageEnchantment(Enchantment.EnchantmentDefinition p_336160_, Optional<TagKey<EntityType<?>>> p_319895_) {
        super(p_336160_);
        this.targets = p_319895_;
    }

    @Override
    public float getDamageBonus(int p_44635_, @Nullable EntityType<?> p_320019_) {
        if (this.targets.isEmpty()) {
            return 1.0F + (float)Math.max(0, p_44635_ - 1) * 0.5F;
        } else {
            return p_320019_ != null && p_320019_.is(this.targets.get()) ? (float)p_44635_ * 2.5F : 0.0F;
        }
    }

    @Override
    public boolean checkCompatibility(Enchantment p_44644_) {
        return !(p_44644_ instanceof DamageEnchantment);
    }

    @Override
    public void doPostAttack(LivingEntity p_44638_, Entity p_44639_, int p_44640_) {
        if (this.targets.isPresent()
            && p_44639_ instanceof LivingEntity livingentity
            && this.targets.get() == EntityTypeTags.SENSITIVE_TO_BANE_OF_ARTHROPODS
            && p_44640_ > 0
            && livingentity.getType().is(this.targets.get())) {
            int i = 20 + p_44638_.getRandom().nextInt(10 * p_44640_);
            livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, i, 3));
        }
    }
}
