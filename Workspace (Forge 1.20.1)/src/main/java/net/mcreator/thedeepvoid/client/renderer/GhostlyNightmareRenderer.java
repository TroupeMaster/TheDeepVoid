
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.entity.GhostlyNightmareEntity;
import net.mcreator.thedeepvoid.client.model.Modelnightmare_remodel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GhostlyNightmareRenderer extends MobRenderer<GhostlyNightmareEntity, Modelnightmare_remodel<GhostlyNightmareEntity>> {
	public GhostlyNightmareRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnightmare_remodel(context.bakeLayer(Modelnightmare_remodel.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<GhostlyNightmareEntity, Modelnightmare_remodel<GhostlyNightmareEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/fake_nightmare_remodel_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GhostlyNightmareEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelnightmare_remodel(Minecraft.getInstance().getEntityModels().bakeLayer(Modelnightmare_remodel.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	protected void scale(GhostlyNightmareEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.2f, 1.2f, 1.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(GhostlyNightmareEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/nightmare_remodel.png");
	}

	@Override
	protected boolean isBodyVisible(GhostlyNightmareEntity entity) {
		return false;
	}

	@Override
	protected boolean isShaking(GhostlyNightmareEntity entity) {
		return true;
	}
}
