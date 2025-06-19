
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

import net.mcreator.thedeepvoid.procedures.SulfurTntEntityModelVisualScaleProcedure;
import net.mcreator.thedeepvoid.procedures.SulfurTntEntityDisplayConditionProcedure;
import net.mcreator.thedeepvoid.entity.SulfurTntEntityEntity;
import net.mcreator.thedeepvoid.client.model.Modelsulfur_tnt;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SulfurTntEntityRenderer extends MobRenderer<SulfurTntEntityEntity, Modelsulfur_tnt<SulfurTntEntityEntity>> {
	public SulfurTntEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsulfur_tnt(context.bakeLayer(Modelsulfur_tnt.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<SulfurTntEntityEntity, Modelsulfur_tnt<SulfurTntEntityEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/pure_white.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SulfurTntEntityEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SulfurTntEntityDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelsulfur_tnt(Minecraft.getInstance().getEntityModels().bakeLayer(Modelsulfur_tnt.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	protected void scale(SulfurTntEntityEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) SulfurTntEntityModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(SulfurTntEntityEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/sulfur_tnt.png");
	}
}
