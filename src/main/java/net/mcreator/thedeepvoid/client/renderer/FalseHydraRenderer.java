
package net.mcreator.thedeepvoid.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thedeepvoid.entity.model.FalseHydraModel;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FalseHydraRenderer extends GeoEntityRenderer<FalseHydraEntity> {
	public FalseHydraRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FalseHydraModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(FalseHydraEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, FalseHydraEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 2f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(FalseHydraEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
