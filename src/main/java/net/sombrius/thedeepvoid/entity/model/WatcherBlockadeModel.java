package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.WatcherBlockadeEntity;

import net.minecraft.resources.ResourceLocation;

public class WatcherBlockadeModel extends GeoModel<WatcherBlockadeEntity> {
	@Override
	public ResourceLocation getAnimationResource(WatcherBlockadeEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/boneblockade.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WatcherBlockadeEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/boneblockade.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WatcherBlockadeEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
