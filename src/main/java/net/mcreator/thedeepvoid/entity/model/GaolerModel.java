package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.GaolerEntity;

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
