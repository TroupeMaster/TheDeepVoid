package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.ThumperEntityEntity;

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
