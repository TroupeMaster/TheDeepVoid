package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.SummonedShadowHandEntity;

public class SummonedShadowHandModel extends GeoModel<SummonedShadowHandEntity> {
	@Override
	public ResourceLocation getAnimationResource(SummonedShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/shadowhand.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SummonedShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/shadowhand.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SummonedShadowHandEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
