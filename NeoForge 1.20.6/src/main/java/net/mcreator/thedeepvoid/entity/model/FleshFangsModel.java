package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.FleshFangsEntity;

public class FleshFangsModel extends GeoModel<FleshFangsEntity> {
	@Override
	public ResourceLocation getAnimationResource(FleshFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/fleshfangs.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FleshFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/fleshfangs.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FleshFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
