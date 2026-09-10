package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.PitPrisonerEntity;

public class PitPrisonerModel extends GeoModel<PitPrisonerEntity> {
	@Override
	public ResourceLocation getAnimationResource(PitPrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/prisoner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PitPrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/prisoner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PitPrisonerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
