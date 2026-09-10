
package net.mcreator.thedeepvoid.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.procedures.DarkSteelFlailDisplayConditionProcedure;
import net.mcreator.thedeepvoid.procedures.DarkSteelFlailDisplayCondition2Procedure;
import net.mcreator.thedeepvoid.entity.DarkSteelFlailEntity;
import net.mcreator.thedeepvoid.client.model.Modeldark_steel_flail;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class DarkSteelFlailRenderer extends MobRenderer<DarkSteelFlailEntity, Modeldark_steel_flail<DarkSteelFlailEntity>> {
	public DarkSteelFlailRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldark_steel_flail(context.bakeLayer(Modeldark_steel_flail.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<DarkSteelFlailEntity, Modeldark_steel_flail<DarkSteelFlailEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/remflail.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, DarkSteelFlailEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (DarkSteelFlailDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modeldark_steel_flail(Minecraft.getInstance().getEntityModels().bakeLayer(Modeldark_steel_flail.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<DarkSteelFlailEntity, Modeldark_steel_flail<DarkSteelFlailEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/flail.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, DarkSteelFlailEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (DarkSteelFlailDisplayCondition2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modeldark_steel_flail(Minecraft.getInstance().getEntityModels().bakeLayer(Modeldark_steel_flail.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DarkSteelFlailEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/flail.png");
	}
}
