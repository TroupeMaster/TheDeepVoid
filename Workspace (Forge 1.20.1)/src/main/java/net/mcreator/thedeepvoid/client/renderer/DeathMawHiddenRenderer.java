
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

import net.mcreator.thedeepvoid.entity.DeathMawHiddenEntity;
import net.mcreator.thedeepvoid.client.model.Modeldeath_maw_hidden;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class DeathMawHiddenRenderer extends MobRenderer<DeathMawHiddenEntity, Modeldeath_maw_hidden<DeathMawHiddenEntity>> {
	public DeathMawHiddenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldeath_maw_hidden(context.bakeLayer(Modeldeath_maw_hidden.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<DeathMawHiddenEntity, Modeldeath_maw_hidden<DeathMawHiddenEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/death_maw_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, DeathMawHiddenEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modeldeath_maw_hidden(Minecraft.getInstance().getEntityModels().bakeLayer(Modeldeath_maw_hidden.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DeathMawHiddenEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/death_maw.png");
	}
}
