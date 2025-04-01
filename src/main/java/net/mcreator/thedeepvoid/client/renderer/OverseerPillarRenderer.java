
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

import net.mcreator.thedeepvoid.entity.OverseerPillarEntity;
import net.mcreator.thedeepvoid.client.model.Modeloverseer_inactive;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OverseerPillarRenderer extends MobRenderer<OverseerPillarEntity, Modeloverseer_inactive<OverseerPillarEntity>> {
	public OverseerPillarRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeloverseer_inactive(context.bakeLayer(Modeloverseer_inactive.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<OverseerPillarEntity, Modeloverseer_inactive<OverseerPillarEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/overseer_pillar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, OverseerPillarEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				EntityModel model = new Modeloverseer_inactive(Minecraft.getInstance().getEntityModels().bakeLayer(Modeloverseer_inactive.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(OverseerPillarEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/overseer_pillar.png");
	}
}
