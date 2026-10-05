
package net.sombrius.thedeepvoid.client.renderer;

import net.sombrius.thedeepvoid.entity.MarrowRootsEntity;
import net.sombrius.thedeepvoid.client.model.ModelmarrowRoots;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.mojang.blaze3d.vertex.PoseStack;

public class MarrowRootsRenderer extends MobRenderer<MarrowRootsEntity, ModelmarrowRoots<MarrowRootsEntity>> {
	public MarrowRootsRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmarrowRoots(context.bakeLayer(ModelmarrowRoots.LAYER_LOCATION)), 0f);
	}

	@Override
	protected void scale(MarrowRootsEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(MarrowRootsEntity entity) {
		return new ResourceLocation("the_deep_void:textures/entities/marrowroots.png");
	}
}
