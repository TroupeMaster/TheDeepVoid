package net.minecraft.world.entity.projectile.windcharge;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.level.Level;

public class BreezeWindCharge extends AbstractWindCharge {
    private static final float RADIUS = 3.0F;

    public BreezeWindCharge(EntityType<? extends AbstractWindCharge> p_326366_, Level p_325976_) {
        super(p_326366_, p_325976_);
    }

    public BreezeWindCharge(Breeze p_326239_, Level p_326041_) {
        super(EntityType.BREEZE_WIND_CHARGE, p_326041_, p_326239_, p_326239_.getX(), p_326239_.getSnoutYPosition(), p_326239_.getZ());
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
                3.0F,
                false,
                Level.ExplosionInteraction.BLOW,
                ParticleTypes.GUST_EMITTER_SMALL,
                ParticleTypes.GUST_EMITTER_LARGE,
                SoundEvents.BREEZE_WIND_CHARGE_BURST
            );
    }
}
