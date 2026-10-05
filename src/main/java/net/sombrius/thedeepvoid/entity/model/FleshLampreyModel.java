package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.FleshLampreyEntity;

import net.minecraft.resources.ResourceLocation;

public class FleshLampreyModel extends GeoModel<FleshLampreyEntity> {
	@Override
	public ResourceLocation getAnimationResource(FleshLampreyEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/fleshlamprey.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FleshLampreyEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/fleshlamprey.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FleshLampreyEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
