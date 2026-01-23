package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BigOverseerEntity;

public class BigOverseerModel extends GeoModel<BigOverseerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BigOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/overseer3blocks.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BigOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/overseer3blocks.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BigOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
