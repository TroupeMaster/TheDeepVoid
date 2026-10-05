package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.PrisonerEntity;

import net.minecraft.resources.ResourceLocation;

public class PrisonerModel extends GeoModel<PrisonerEntity> {
	@Override
	public ResourceLocation getAnimationResource(PrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/prisoner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/prisoner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
