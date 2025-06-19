
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

import net.mcreator.thedeepvoid.entity.SummonedCharredSpikeEntity;
import net.mcreator.thedeepvoid.client.model.Modelspike;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SummonedCharredSpikeRenderer extends MobRenderer<SummonedCharredSpikeEntity, Modelspike<SummonedCharredSpikeEntity>> {
	public SummonedCharredSpikeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspike(context.bakeLayer(Modelspike.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<SummonedCharredSpikeEntity, Modelspike<SummonedCharredSpikeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/spike.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SummonedCharredSpikeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelspike(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspike.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SummonedCharredSpikeEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/spike.png");
	}
}
