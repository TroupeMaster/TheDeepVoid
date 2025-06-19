package net.minecraft.world.entity.projectile;

import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public abstract class AbstractHurtingProjectile extends Projectile {
    public static final double ATTACK_DEFLECTION_SCALE = 0.1;
    public static final double BOUNCE_DEFLECTION_SCALE = 0.05;
    public double xPower;
    public double yPower;
    public double zPower;

    protected AbstractHurtingProjectile(EntityType<? extends AbstractHurtingProjectile> p_36833_, Level p_36834_) {
        super(p_36833_, p_36834_);
    }

    protected AbstractHurtingProjectile(
        EntityType<? extends AbstractHurtingProjectile> p_312669_, double p_312561_, double p_312829_, double p_312607_, Level p_312011_
    ) {
        this(p_312669_, p_312011_);
        this.setPos(p_312561_, p_312829_, p_312607_);
    }

    public AbstractHurtingProjectile(
        EntityType<? extends AbstractHurtingProjectile> p_36817_,
        double p_36818_,
        double p_36819_,
        double p_36820_,
        double p_36821_,
        double p_36822_,
        double p_36823_,
        Level p_36824_
    ) {
        this(p_36817_, p_36824_);
        this.moveTo(p_36818_, p_36819_, p_36820_, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        this.assignPower(p_36821_, p_36822_, p_36823_);
    }

    public AbstractHurtingProjectile(
        EntityType<? extends AbstractHurtingProjectile> p_36826_, LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, Level p_36831_
    ) {
        this(p_36826_, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_);
        this.setOwner(p_36827_);
        this.setRot(p_36827_.getYRot(), p_36827_.getXRot());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326181_) {
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }

        d0 *= 64.0;
        return p_36837_ < d0 * d0;
    }

    protected ClipContext.Block getClipType() {
        return ClipContext.Block.COLLIDER;
    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        if (this.level().isClientSide || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            super.tick();
            if (this.shouldBurn()) {
                this.igniteForSeconds(1);
            }

            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity, this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS && !net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult)) {
                this.hitTargetOrDeflectSelf(hitresult);
            }

            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            float f;
            if (this.isInWater()) {
                for (int i = 0; i < 4; i++) {
                    float f1 = 0.25F;
                    this.level().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25, d1 - vec3.y * 0.25, d2 - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
                }

                f = this.getLiquidInertia();
            } else {
                f = this.getInertia();
            }

            this.setDeltaMovement(vec3.add(this.xPower, this.yPower, this.zPower).scale((double)f));
            ParticleOptions particleoptions = this.getTrailParticle();
            if (particleoptions != null) {
                this.level().addParticle(particleoptions, d0, d1 + 0.5, d2, 0.0, 0.0, 0.0);
            }

            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    @Override
    public boolean hurt(DamageSource p_341896_, float p_341906_) {
        return !this.isInvulnerableTo(p_341896_);
    }

    @Override
    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }

    protected boolean shouldBurn() {
        return true;
    }

    @Nullable
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.SMOKE;
    }

    protected float getInertia() {
        return 0.95F;
    }

    protected float getLiquidInertia() {
        return 0.8F;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_36848_) {
        super.addAdditionalSaveData(p_36848_);
        p_36848_.put("power", this.newDoubleList(new double[]{this.xPower, this.yPower, this.zPower}));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_36844_) {
        super.readAdditionalSaveData(p_36844_);
        if (p_36844_.contains("power", 9)) {
            ListTag listtag = p_36844_.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }
    }

    @Override
    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new ClientboundAddEntityPacket(
            this.getId(),
            this.getUUID(),
            this.getX(),
            this.getY(),
            this.getZ(),
            this.getXRot(),
            this.getYRot(),
            this.getType(),
            i,
            new Vec3(this.xPower, this.yPower, this.zPower),
            0.0
        );
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket p_150128_) {
        super.recreateFromPacket(p_150128_);
        double d0 = p_150128_.getXa();
        double d1 = p_150128_.getYa();
        double d2 = p_150128_.getZa();
        this.assignPower(d0, d1, d2);
    }

    private void assignPower(double p_333940_, double p_334030_, double p_333897_) {
        double d0 = Math.sqrt(p_333940_ * p_333940_ + p_334030_ * p_334030_ + p_333897_ * p_333897_);
        if (d0 != 0.0) {
            this.xPower = p_333940_ / d0 * 0.1;
            this.yPower = p_334030_ / d0 * 0.1;
            this.zPower = p_333897_ / d0 * 0.1;
        }
    }

    @Override
    protected void onDeflection(@Nullable Entity p_341940_, boolean p_341895_) {
        super.onDeflection(p_341940_, p_341895_);
        if (p_341895_) {
            this.xPower = this.getDeltaMovement().x * 0.1;
            this.yPower = this.getDeltaMovement().y * 0.1;
            this.zPower = this.getDeltaMovement().z * 0.1;
        } else {
            this.xPower = this.getDeltaMovement().x * 0.05;
            this.yPower = this.getDeltaMovement().y * 0.05;
            this.zPower = this.getDeltaMovement().z * 0.05;
        }
    }
}
