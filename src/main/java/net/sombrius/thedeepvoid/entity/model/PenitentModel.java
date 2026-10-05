package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.PenitentEntity;

import net.minecraft.resources.ResourceLocation;

public class PenitentModel extends GeoModel<PenitentEntity> {
	@Override
	public ResourceLocation getAnimationResource(PenitentEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/penitent.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PenitentEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/penitent.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PenitentEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
