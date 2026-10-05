package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.SporeSpewerEntity;

import net.minecraft.resources.ResourceLocation;

public class SporeSpewerModel extends GeoModel<SporeSpewerEntity> {
	@Override
	public ResourceLocation getAnimationResource(SporeSpewerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/sporespewer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SporeSpewerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/sporespewer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SporeSpewerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
