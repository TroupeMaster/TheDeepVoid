package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.SkullSmasherEntity;

import net.minecraft.resources.ResourceLocation;

public class SkullSmasherModel extends GeoModel<SkullSmasherEntity> {
	@Override
	public ResourceLocation getAnimationResource(SkullSmasherEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/skull_smasher.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SkullSmasherEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/skull_smasher.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SkullSmasherEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
