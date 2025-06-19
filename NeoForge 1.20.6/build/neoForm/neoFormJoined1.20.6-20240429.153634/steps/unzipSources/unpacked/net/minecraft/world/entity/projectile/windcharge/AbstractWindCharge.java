package net.minecraft.world.entity.projectile.windcharge;

import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public abstract class AbstractWindCharge extends AbstractHurtingProjectile implements ItemSupplier {
    public static final AbstractWindCharge.WindChargeDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new AbstractWindCharge.WindChargeDamageCalculator();

    public AbstractWindCharge(EntityType<? extends AbstractWindCharge> p_325927_, Level p_326350_) {
        super(p_325927_, p_326350_);
    }

    public AbstractWindCharge(
        EntityType<? extends AbstractWindCharge> p_326427_, Level p_325931_, Entity p_325997_, double p_326275_, double p_325936_, double p_326369_
    ) {
        super(p_326427_, p_326275_, p_325936_, p_326369_, p_325931_);
        this.setOwner(p_325997_);
    }

    AbstractWindCharge(
        EntityType<? extends AbstractWindCharge> p_326232_,
        double p_326236_,
        double p_326440_,
        double p_326413_,
        double p_326381_,
        double p_326118_,
        double p_326053_,
        Level p_326449_
    ) {
        super(p_326232_, p_326236_, p_326440_, p_326413_, p_326381_, p_326118_, p_326053_, p_326449_);
    }

    @Override
    protected AABB makeBoundingBox() {
        float f = this.getType().getDimensions().width() / 2.0F;
        float f1 = this.getType().getDimensions().height();
        float f2 = 0.15F;
        return new AABB(
            this.position().x - (double)f,
            this.position().y - 0.15F,
            this.position().z - (double)f,
            this.position().x + (double)f,
            this.position().y - 0.15F + (double)f1,
            this.position().z + (double)f
        );
    }

    @Override
    public boolean canCollideWith(Entity p_326023_) {
        return p_326023_ instanceof AbstractWindCharge ? false : super.canCollideWith(p_326023_);
    }

    @Override
    protected boolean canHitEntity(Entity p_326159_) {
        if (p_326159_ instanceof AbstractWindCharge) {
            return false;
        } else {
            return p_326159_.getType() == EntityType.END_CRYSTAL ? false : super.canHitEntity(p_326159_);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult p_326121_) {
        super.onHitEntity(p_326121_);
        if (!this.level().isClientSide) {
            LivingEntity livingentity = this.getOwner() instanceof LivingEntity livingentity1 ? livingentity1 : null;
            Entity entity = p_326121_.getEntity().getPassengerClosestTo(p_326121_.getLocation()).orElse(p_326121_.getEntity());
            if (livingentity != null) {
                livingentity.setLastHurtMob(entity);
            }

            entity.hurt(this.damageSources().windCharge(this, livingentity), 1.0F);
            this.explode();
        }
    }

    @Override
    public void push(double p_334071_, double p_333979_, double p_333996_) {
    }

    protected abstract void explode();

    @Override
    protected void onHitBlock(BlockHitResult p_325933_) {
        super.onHitBlock(p_325933_);
        if (!this.level().isClientSide) {
            this.explode();
            this.discard();
        }
    }

    @Override
    protected void onHit(HitResult p_326337_) {
        super.onHit(p_326337_);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected float getInertia() {
        return 1.0F;
    }

    @Override
    protected float getLiquidInertia() {
        return this.getInertia();
    }

    @Nullable
    @Override
    protected ParticleOptions getTrailParticle() {
        return null;
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide && this.getBlockY() > this.level().getMaxBuildHeight() + 30) {
            this.explode();
            this.discard();
        } else {
            super.tick();
        }
    }

    public static class WindChargeDamageCalculator extends ExplosionDamageCalculator {
        @Override
        public boolean shouldDamageEntity(Explosion p_326467_, Entity p_326284_) {
            return false;
        }

        @Override
        public Optional<Float> getBlockExplosionResistance(
            Explosion p_326498_, BlockGetter p_326469_, BlockPos p_326029_, BlockState p_325970_, FluidState p_326399_
        ) {
            return p_325970_.is(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS) ? Optional.of(3600000.0F) : Optional.empty();
        }
    }
}
