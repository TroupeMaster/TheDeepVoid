package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.MaskedHunterEntity;

public class MaskedHunterModel extends GeoModel<MaskedHunterEntity> {
	@Override
	public ResourceLocation getAnimationResource(MaskedHunterEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/huntertrue.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MaskedHunterEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/huntertrue.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MaskedHunterEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
