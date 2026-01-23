
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

import net.mcreator.thedeepvoid.entity.PlayerCageEntity;
import net.mcreator.thedeepvoid.client.model.Modelplayer_cage;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PlayerCageRenderer extends MobRenderer<PlayerCageEntity, Modelplayer_cage<PlayerCageEntity>> {
	public PlayerCageRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer_cage(context.bakeLayer(Modelplayer_cage.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<PlayerCageEntity, Modelplayer_cage<PlayerCageEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_deep_void:textures/entities/gaoler.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, PlayerCageEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				EntityModel model = new Modelplayer_cage(Minecraft.getInstance().getEntityModels().bakeLayer(Modelplayer_cage.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PlayerCageEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/gaoler.png");
	}
}
