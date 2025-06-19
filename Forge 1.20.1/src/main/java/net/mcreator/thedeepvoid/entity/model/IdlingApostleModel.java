package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.IdlingApostleEntity;

public class IdlingApostleModel extends GeoModel<IdlingApostleEntity> {
	@Override
	public ResourceLocation getAnimationResource(IdlingApostleEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/apostle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IdlingApostleEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/apostle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IdlingApostleEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
