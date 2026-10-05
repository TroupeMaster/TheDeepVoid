package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.ShankPrisonerEntity;

import net.minecraft.resources.ResourceLocation;

public class ShankPrisonerModel extends GeoModel<ShankPrisonerEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShankPrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/shankprisoner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShankPrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/shankprisoner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShankPrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
