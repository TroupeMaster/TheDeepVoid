
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.entity.OverseerBigPillarEntity;
import net.mcreator.thedeepvoid.client.model.Modeloverseer_inactive_big;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OverseerBigPillarRenderer extends MobRenderer<OverseerBigPillarEntity, Modeloverseer_inactive_big<OverseerBigPillarEntity>> {
	public OverseerBigPillarRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeloverseer_inactive_big(context.bakeLayer(Modeloverseer_inactive_big.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<OverseerBigPillarEntity, Modeloverseer_inactive_big<OverseerBigPillarEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/overseer_pillar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, OverseerBigPillarEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				EntityModel model = new Modeloverseer_inactive_big(Minecraft.getInstance().getEntityModels().bakeLayer(Modeloverseer_inactive_big.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(OverseerBigPillarEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/overseer_pillar.png");
	}
}
