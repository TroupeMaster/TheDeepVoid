package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thedeepvoid.entity.TenebrisCultroEntity;
import net.mcreator.thedeepvoid.client.model.Modeldark_throw_knife;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class TenebrisCultroRenderer extends EntityRenderer<TenebrisCultroEntity> {
	private static final ResourceLocation texture = new ResourceLocation("the_deep_void:textures/entities/dark_throw_knife.png");
	private final Modeldark_throw_knife model;

	public TenebrisCultroRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modeldark_throw_knife(context.bakeLayer(Modeldark_throw_knife.LAYER_LOCATION));
	}

	@Override
	public void render(TenebrisCultroEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(TenebrisCultroEntity entity) {
		return texture;
	}
}
