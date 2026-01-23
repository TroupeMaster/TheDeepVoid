package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.GiantShadowHandEntity;

public class GiantShadowHandModel extends GeoModel<GiantShadowHandEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiantShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/giantshadowhand.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiantShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/giantshadowhand.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiantShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
