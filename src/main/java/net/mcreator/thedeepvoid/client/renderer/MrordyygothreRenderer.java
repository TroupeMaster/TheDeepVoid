
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

import net.mcreator.thedeepvoid.entity.MrordyygothreEntity;
import net.mcreator.thedeepvoid.client.model.Modelweaver;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MrordyygothreRenderer extends MobRenderer<MrordyygothreEntity, Modelweaver<MrordyygothreEntity>> {
	public MrordyygothreRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelweaver(context.bakeLayer(Modelweaver.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<MrordyygothreEntity, Modelweaver<MrordyygothreEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/weaver_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MrordyygothreEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelweaver(Minecraft.getInstance().getEntityModels().bakeLayer(Modelweaver.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MrordyygothreEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/weaver.png");
	}
}
