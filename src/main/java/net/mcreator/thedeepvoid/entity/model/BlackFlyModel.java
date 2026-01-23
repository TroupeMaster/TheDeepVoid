package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BlackFlyEntity;

public class BlackFlyModel extends GeoModel<BlackFlyEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlackFlyEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/voidfly.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlackFlyEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/voidfly.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlackFlyEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
