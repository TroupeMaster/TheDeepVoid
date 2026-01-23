package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.DarkSteelSawEntity;

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
