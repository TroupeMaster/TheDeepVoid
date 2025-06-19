package net.minecraft.world.entity.projectile.windcharge;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WindCharge extends AbstractWindCharge {
    private static final WindCharge.WindChargePlayerDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new WindCharge.WindChargePlayerDamageCalculator();
    private static final float RADIUS = 1.2F;

    public WindCharge(EntityType<? extends AbstractWindCharge> p_326226_, Level p_326464_) {
        super(p_326226_, p_326464_);
    }

    public WindCharge(Player p_326044_, Level p_326101_, double p_326183_, double p_326157_, double p_325928_) {
        super(EntityType.WIND_CHARGE, p_326101_, p_326044_, p_326183_, p_326157_, p_325928_);
    }

    public WindCharge(Level p_326007_, double p_326331_, double p_326001_, double p_325990_, double p_326051_, double p_326357_, double p_326018_) {
        super(EntityType.WIND_CHARGE, p_326331_, p_326001_, p_325990_, p_326051_, p_326357_, p_326018_, p_326007_);
    }

    @Override
    protected void explode() {
        this.level()
            .explode(
                this,
                null,
                EXPLOSION_DAMAGE_CALCULATOR,
                this.getX(),
                this.getY(),
                this.getZ(),
                1.2F,
                false,
                Level.ExplosionInteraction.BLOW,
                ParticleTypes.GUST_EMITTER_SMALL,
                ParticleTypes.GUST_EMITTER_LARGE,
                SoundEvents.WIND_CHARGE_BURST
            );
    }

    public static final class WindChargePlayerDamageCalculator extends AbstractWindCharge.WindChargeDamageCalculator {
        @Override
        public float getKnockbackMultiplier(Entity p_341013_) {
            return 1.1F;
        }
    }
}
