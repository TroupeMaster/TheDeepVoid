package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.PenitentEntity;

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
