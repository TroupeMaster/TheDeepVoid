package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BogWalkerEntity;

public class BogWalkerModel extends GeoModel<BogWalkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BogWalkerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/bogwalker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BogWalkerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/bogwalker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BogWalkerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
