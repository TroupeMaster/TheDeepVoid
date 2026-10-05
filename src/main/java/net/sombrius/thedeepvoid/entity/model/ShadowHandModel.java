package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.ShadowHandEntity;

import net.minecraft.resources.ResourceLocation;

public class ShadowHandModel extends GeoModel<ShadowHandEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/shadowhand.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/shadowhand.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
