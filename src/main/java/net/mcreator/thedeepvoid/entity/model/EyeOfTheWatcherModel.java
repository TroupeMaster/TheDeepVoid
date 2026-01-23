package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.EyeOfTheWatcherEntity;

public class EyeOfTheWatcherModel extends GeoModel<EyeOfTheWatcherEntity> {
	@Override
	public ResourceLocation getAnimationResource(EyeOfTheWatcherEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/eyeofthewatcher.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EyeOfTheWatcherEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/eyeofthewatcher.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EyeOfTheWatcherEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
