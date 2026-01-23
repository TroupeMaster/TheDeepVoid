package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;

public class WeaverOfSoulsModel extends GeoModel<WeaverOfSoulsEntity> {
	@Override
	public ResourceLocation getAnimationResource(WeaverOfSoulsEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/fallenweaver.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WeaverOfSoulsEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/fallenweaver.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WeaverOfSoulsEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
