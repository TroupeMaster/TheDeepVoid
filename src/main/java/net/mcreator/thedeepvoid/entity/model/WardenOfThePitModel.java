package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.WardenOfThePitEntity;

public class WardenOfThePitModel extends GeoModel<WardenOfThePitEntity> {
	@Override
	public ResourceLocation getAnimationResource(WardenOfThePitEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/wardenofthepit.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WardenOfThePitEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/wardenofthepit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WardenOfThePitEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
