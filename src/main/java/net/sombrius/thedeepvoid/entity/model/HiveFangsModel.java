package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.HiveFangsEntity;

import net.minecraft.resources.ResourceLocation;

public class HiveFangsModel extends GeoModel<HiveFangsEntity> {
	@Override
	public ResourceLocation getAnimationResource(HiveFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/hivefangs.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HiveFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/hivefangs.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HiveFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
