package net.minecraft.world.entity.projectile;

import javax.annotation.Nullable;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

@FunctionalInterface
public interface ProjectileDeflection {
    ProjectileDeflection NONE = (p_320379_, p_320626_, p_320122_) -> {
    };
    ProjectileDeflection REVERSE = (p_341881_, p_341882_, p_341883_) -> {
        float f = 170.0F + p_341883_.nextFloat() * 20.0F;
        p_341881_.setDeltaMovement(p_341881_.getDeltaMovement().scale(-0.5));
        p_341881_.setYRot(p_341881_.getYRot() + f);
        p_341881_.yRotO += f;
        p_341881_.hurtMarked = true;
    };
    ProjectileDeflection AIM_DEFLECT = (p_341972_, p_341973_, p_341974_) -> {
        if (p_341973_ != null) {
            Vec3 vec3 = p_341973_.getLookAngle().normalize();
            p_341972_.setDeltaMovement(vec3);
            p_341972_.hurtMarked = true;
        }
    };
    ProjectileDeflection MOMENTUM_DEFLECT = (p_341969_, p_341970_, p_341971_) -> {
        if (p_341970_ != null) {
            Vec3 vec3 = p_341970_.getDeltaMovement().normalize();
            p_341969_.setDeltaMovement(vec3);
            p_341969_.hurtMarked = true;
        }
    };

    void deflect(Projectile p_320311_, @Nullable Entity p_320130_, RandomSource p_320125_);
}
