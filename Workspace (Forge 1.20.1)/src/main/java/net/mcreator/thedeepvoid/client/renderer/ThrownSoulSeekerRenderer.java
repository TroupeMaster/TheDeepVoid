
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

import net.mcreator.thedeepvoid.entity.ThrownSoulSeekerEntity;
import net.mcreator.thedeepvoid.client.model.Modelthrown_soul_seeker;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ThrownSoulSeekerRenderer extends MobRenderer<ThrownSoulSeekerEntity, Modelthrown_soul_seeker<ThrownSoulSeekerEntity>> {
	public ThrownSoulSeekerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelthrown_soul_seeker(context.bakeLayer(Modelthrown_soul_seeker.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<ThrownSoulSeekerEntity, Modelthrown_soul_seeker<ThrownSoulSeekerEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/thrown_soul_seeker.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ThrownSoulSeekerEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelthrown_soul_seeker(Minecraft.getInstance().getEntityModels().bakeLayer(Modelthrown_soul_seeker.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
			}
		});
	}

	@Override
	protected void scale(ThrownSoulSeekerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.8f, 1.8f, 1.8f);
	}

	@Override
	public ResourceLocation getTextureLocation(ThrownSoulSeekerEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/thrown_soul_seeker.png");
	}
}
