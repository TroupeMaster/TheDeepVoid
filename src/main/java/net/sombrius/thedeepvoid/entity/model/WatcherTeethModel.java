package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.WatcherTeethEntity;

import net.minecraft.resources.ResourceLocation;

public class WatcherTeethModel extends GeoModel<WatcherTeethEntity> {
	@Override
	public ResourceLocation getAnimationResource(WatcherTeethEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/watcher_teeth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WatcherTeethEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/watcher_teeth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WatcherTeethEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
