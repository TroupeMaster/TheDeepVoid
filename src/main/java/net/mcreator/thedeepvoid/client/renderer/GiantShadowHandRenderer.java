
package net.mcreator.thedeepvoid.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thedeepvoid.entity.model.GiantShadowHandModel;
import net.mcreator.thedeepvoid.entity.layer.GiantShadowHandLayer;
import net.mcreator.thedeepvoid.entity.GiantShadowHandEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GiantShadowHandRenderer extends GeoEntityRenderer<GiantShadowHandEntity> {
	public GiantShadowHandRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GiantShadowHandModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new GiantShadowHandLayer(this));
	}

	@Override
	public RenderType getRenderType(GiantShadowHandEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, GiantShadowHandEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
