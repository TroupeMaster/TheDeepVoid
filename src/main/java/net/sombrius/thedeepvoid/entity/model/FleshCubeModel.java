package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.FleshCubeEntity;

import net.minecraft.resources.ResourceLocation;

public class FleshCubeModel extends GeoModel<FleshCubeEntity> {
	@Override
	public ResourceLocation getAnimationResource(FleshCubeEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/fleshcube.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FleshCubeEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/fleshcube.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FleshCubeEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
