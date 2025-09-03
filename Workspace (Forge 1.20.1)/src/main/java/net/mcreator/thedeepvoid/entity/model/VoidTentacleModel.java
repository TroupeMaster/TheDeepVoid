package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.VoidTentacleEntity;

public class VoidTentacleModel extends GeoModel<VoidTentacleEntity> {
	@Override
	public ResourceLocation getAnimationResource(VoidTentacleEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/void_tentacle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VoidTentacleEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/void_tentacle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VoidTentacleEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
