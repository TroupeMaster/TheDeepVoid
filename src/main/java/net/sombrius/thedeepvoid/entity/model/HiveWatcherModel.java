package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.HiveWatcherEntity;

import net.minecraft.resources.ResourceLocation;

public class HiveWatcherModel extends GeoModel<HiveWatcherEntity> {
	@Override
	public ResourceLocation getAnimationResource(HiveWatcherEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/hivewatcher.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HiveWatcherEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/hivewatcher.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HiveWatcherEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
