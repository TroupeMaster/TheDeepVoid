package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.HivemindTentaclesEntity;

public class HivemindTentaclesModel extends GeoModel<HivemindTentaclesEntity> {
	@Override
	public ResourceLocation getAnimationResource(HivemindTentaclesEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/flesh_tentacles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HivemindTentaclesEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/flesh_tentacles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HivemindTentaclesEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
