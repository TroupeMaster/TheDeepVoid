package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.ThumperEntityEntity;

import net.minecraft.resources.ResourceLocation;

public class ThumperEntityModel extends GeoModel<ThumperEntityEntity> {
	@Override
	public ResourceLocation getAnimationResource(ThumperEntityEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/thumper.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ThumperEntityEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/thumper.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ThumperEntityEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
