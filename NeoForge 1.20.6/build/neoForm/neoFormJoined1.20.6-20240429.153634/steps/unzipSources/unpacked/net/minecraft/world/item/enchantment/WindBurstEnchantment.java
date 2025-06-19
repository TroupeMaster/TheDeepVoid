package net.minecraft.world.item.enchantment;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.windcharge.AbstractWindCharge;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.Level;

public class WindBurstEnchantment extends Enchantment {
    public WindBurstEnchantment() {
        super(
            Enchantment.definition(
                ItemTags.MACE_ENCHANTABLE,
                2,
                3,
                Enchantment.dynamicCost(15, 9),
                Enchantment.dynamicCost(65, 9),
                4,
                FeatureFlagSet.of(FeatureFlags.UPDATE_1_21),
                EquipmentSlot.MAINHAND
            )
        );
    }

    @Override
    public void doPostItemStackHurt(LivingEntity p_338647_, Entity p_338351_, int p_338250_) {
        float f = 0.25F + 0.25F * (float)p_338250_;
        p_338647_.level()
            .explode(
                null,
                null,
                new WindBurstEnchantment.WindBurstEnchantmentDamageCalculator(f),
                p_338647_.getX(),
                p_338647_.getY(),
                p_338647_.getZ(),
                3.5F,
                false,
                Level.ExplosionInteraction.BLOW,
                ParticleTypes.GUST_EMITTER_SMALL,
                ParticleTypes.GUST_EMITTER_LARGE,
                SoundEvents.WIND_CHARGE_BURST
            );
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    static final class WindBurstEnchantmentDamageCalculator extends AbstractWindCharge.WindChargeDamageCalculator {
        private final float knockBackPower;

        public WindBurstEnchantmentDamageCalculator(float p_338584_) {
            this.knockBackPower = p_338584_;
        }

        @Override
        public float getKnockbackMultiplier(Entity p_341224_) {
            boolean flag1;
            label17: {
                if (p_341224_ instanceof Player player && player.getAbilities().flying) {
                    flag1 = true;
                    break label17;
                }

                flag1 = false;
            }

            boolean flag = flag1;
            return !flag ? this.knockBackPower : 0.0F;
        }
    }
}
