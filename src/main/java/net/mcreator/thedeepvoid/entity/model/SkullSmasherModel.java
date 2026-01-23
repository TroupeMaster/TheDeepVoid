package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.SkullSmasherEntity;

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
