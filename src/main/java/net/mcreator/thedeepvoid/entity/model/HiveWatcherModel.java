package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;

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
