package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.GaolerEntity;

import net.minecraft.resources.ResourceLocation;

public class GaolerModel extends GeoModel<GaolerEntity> {
	@Override
	public ResourceLocation getAnimationResource(GaolerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/gaoler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GaolerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/gaoler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GaolerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
