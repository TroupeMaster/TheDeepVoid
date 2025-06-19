package net.minecraft.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@OnlyIn(Dist.CLIENT)
public abstract class SingleQuadParticle extends Particle {
    protected float quadSize;
    private final Quaternionf rotation = new Quaternionf();

    protected SingleQuadParticle(ClientLevel p_107665_, double p_107666_, double p_107667_, double p_107668_) {
        super(p_107665_, p_107666_, p_107667_, p_107668_);
        this.quadSize = 0.1F * (this.random.nextFloat() * 0.5F + 0.5F) * 2.0F;
    }

    protected SingleQuadParticle(
        ClientLevel p_107670_, double p_107671_, double p_107672_, double p_107673_, double p_107674_, double p_107675_, double p_107676_
    ) {
        super(p_107670_, p_107671_, p_107672_, p_107673_, p_107674_, p_107675_, p_107676_);
        this.quadSize = 0.1F * (this.random.nextFloat() * 0.5F + 0.5F) * 2.0F;
    }

    public SingleQuadParticle.FacingCameraMode getFacingCameraMode() {
        return SingleQuadParticle.FacingCameraMode.LOOKAT_XYZ;
    }

    @Override
    public void render(VertexConsumer p_107678_, Camera p_107679_, float p_107680_) {
        Vec3 vec3 = p_107679_.getPosition();
        float f = (float)(Mth.lerp((double)p_107680_, this.xo, this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)p_107680_, this.yo, this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)p_107680_, this.zo, this.z) - vec3.z());
        this.getFacingCameraMode().setRotation(this.rotation, p_107679_, p_107680_);
        if (this.roll != 0.0F) {
            this.rotation.rotateZ(Mth.lerp(p_107680_, this.oRoll, this.roll));
        }

        Vector3f[] avector3f = new Vector3f[]{
            new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)
        };
        float f3 = this.getQuadSize(p_107680_);

        for (int i = 0; i < 4; i++) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate(this.rotation);
            vector3f.mul(f3);
            vector3f.add(f, f1, f2);
        }

        float f6 = this.getU0();
        float f7 = this.getU1();
        float f4 = this.getV0();
        float f5 = this.getV1();
        int j = this.getLightColor(p_107680_);
        p_107678_.vertex((double)avector3f[0].x(), (double)avector3f[0].y(), (double)avector3f[0].z())
            .uv(f7, f5)
            .color(this.rCol, this.gCol, this.bCol, this.alpha)
            .uv2(j)
            .endVertex();
        p_107678_.vertex((double)avector3f[1].x(), (double)avector3f[1].y(), (double)avector3f[1].z())
            .uv(f7, f4)
            .color(this.rCol, this.gCol, this.bCol, this.alpha)
            .uv2(j)
            .endVertex();
        p_107678_.vertex((double)avector3f[2].x(), (double)avector3f[2].y(), (double)avector3f[2].z())
            .uv(f6, f4)
            .color(this.rCol, this.gCol, this.bCol, this.alpha)
            .uv2(j)
            .endVertex();
        p_107678_.vertex((double)avector3f[3].x(), (double)avector3f[3].y(), (double)avector3f[3].z())
            .uv(f6, f5)
            .color(this.rCol, this.gCol, this.bCol, this.alpha)
            .uv2(j)
            .endVertex();
    }

    @Override
    public net.minecraft.world.phys.AABB getRenderBoundingBox(float partialTicks) {
        float size = getQuadSize(partialTicks);
        return new net.minecraft.world.phys.AABB(this.x - size, this.y - size, this.z - size, this.x + size, this.y + size, this.z + size);
    }

    public float getQuadSize(float p_107681_) {
        return this.quadSize;
    }

    @Override
    public Particle scale(float p_107683_) {
        this.quadSize *= p_107683_;
        return super.scale(p_107683_);
    }

    protected abstract float getU0();

    protected abstract float getU1();

    protected abstract float getV0();

    protected abstract float getV1();

    @OnlyIn(Dist.CLIENT)
    public interface FacingCameraMode {
        SingleQuadParticle.FacingCameraMode LOOKAT_XYZ = (p_312316_, p_311843_, p_312119_) -> p_312316_.set(p_311843_.rotation());
        SingleQuadParticle.FacingCameraMode LOOKAT_Y = (p_312695_, p_312346_, p_312064_) -> p_312695_.set(
                0.0F, p_312346_.rotation().y, 0.0F, p_312346_.rotation().w
            );

        void setRotation(Quaternionf p_312344_, Camera p_312241_, float p_312755_);
    }
}
