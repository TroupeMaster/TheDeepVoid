package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsBossEntity;

public class WeaverOfSoulsBossModel extends GeoModel<WeaverOfSoulsBossEntity> {
	@Override
	public ResourceLocation getAnimationResource(WeaverOfSoulsBossEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/fallenweaver.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WeaverOfSoulsBossEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/fallenweaver.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WeaverOfSoulsBossEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
