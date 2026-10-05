package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.GiantBoneSpikeEntity;

import net.minecraft.resources.ResourceLocation;

public class GiantBoneSpikeModel extends GeoModel<GiantBoneSpikeEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiantBoneSpikeEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/giant_spike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiantBoneSpikeEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/giant_spike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiantBoneSpikeEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
