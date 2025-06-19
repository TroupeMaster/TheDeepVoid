
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

import net.mcreator.thedeepvoid.entity.HandSpawnEntity;
import net.mcreator.thedeepvoid.client.model.Modelspike_spawn;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HandSpawnRenderer extends MobRenderer<HandSpawnEntity, Modelspike_spawn<HandSpawnEntity>> {
	public HandSpawnRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspike_spawn(context.bakeLayer(Modelspike_spawn.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<HandSpawnEntity, Modelspike_spawn<HandSpawnEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/spike_spawn.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, HandSpawnEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelspike_spawn(Minecraft.getInstance().getEntityModels().bakeLayer(Modelspike_spawn.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(HandSpawnEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/spike_spawn.png");
	}
}
