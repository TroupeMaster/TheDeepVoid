package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.DarkSteelSawEntity;

import net.minecraft.resources.ResourceLocation;

public class DarkSteelSawModel extends GeoModel<DarkSteelSawEntity> {
	@Override
	public ResourceLocation getAnimationResource(DarkSteelSawEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/darksteelsaw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkSteelSawEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/darksteelsaw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkSteelSawEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
