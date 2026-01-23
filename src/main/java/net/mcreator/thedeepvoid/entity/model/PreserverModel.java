package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.PreserverEntity;

public class PreserverModel extends GeoModel<PreserverEntity> {
	@Override
	public ResourceLocation getAnimationResource(PreserverEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/preserver.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PreserverEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/preserver.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PreserverEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
