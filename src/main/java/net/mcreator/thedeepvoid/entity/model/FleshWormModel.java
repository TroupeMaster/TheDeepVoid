package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.FleshWormEntity;

public class FleshWormModel extends GeoModel<FleshWormEntity> {
	@Override
	public ResourceLocation getAnimationResource(FleshWormEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/fleshworm.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FleshWormEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/fleshworm.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FleshWormEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
