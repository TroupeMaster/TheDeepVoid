package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.HarbingerCloneEntity;

import net.minecraft.resources.ResourceLocation;

public class HarbingerCloneModel extends GeoModel<HarbingerCloneEntity> {
	@Override
	public ResourceLocation getAnimationResource(HarbingerCloneEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/harbinger.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HarbingerCloneEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/harbinger.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HarbingerCloneEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
