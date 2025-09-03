package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.LastingShadowHandEntity;

public class LastingShadowHandModel extends GeoModel<LastingShadowHandEntity> {
	@Override
	public ResourceLocation getAnimationResource(LastingShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/shadowhand.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LastingShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/shadowhand.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LastingShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
