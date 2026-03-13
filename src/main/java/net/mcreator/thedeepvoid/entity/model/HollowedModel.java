package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.HollowedEntity;

public class HollowedModel extends GeoModel<HollowedEntity> {
	@Override
	public ResourceLocation getAnimationResource(HollowedEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/hollowed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HollowedEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/hollowed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HollowedEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
