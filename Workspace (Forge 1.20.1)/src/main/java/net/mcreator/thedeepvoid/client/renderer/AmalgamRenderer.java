
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.procedures.AmalgamDisplayConditionProcedure;
import net.mcreator.thedeepvoid.entity.AmalgamEntity;
import net.mcreator.thedeepvoid.client.model.Modelamalgam_rework;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AmalgamRenderer extends MobRenderer<AmalgamEntity, Modelamalgam_rework<AmalgamEntity>> {
	public AmalgamRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamalgam_rework(context.bakeLayer(Modelamalgam_rework.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<AmalgamEntity, Modelamalgam_rework<AmalgamEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/amalgam_rework_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AmalgamEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelamalgam_rework(Minecraft.getInstance().getEntityModels().bakeLayer(Modelamalgam_rework.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
		this.addLayer(new RenderLayer<AmalgamEntity, Modelamalgam_rework<AmalgamEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/amalgam_rework.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AmalgamEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (AmalgamDisplayConditionProcedure.execute(world, x, y, z)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelamalgam_rework(Minecraft.getInstance().getEntityModels().bakeLayer(Modelamalgam_rework.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AmalgamEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/amalgam_camo.png");
	}
}
