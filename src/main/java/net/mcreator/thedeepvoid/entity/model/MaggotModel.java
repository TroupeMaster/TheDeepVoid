package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.MaggotEntity;

public class MaggotModel extends GeoModel<MaggotEntity> {
	@Override
	public ResourceLocation getAnimationResource(MaggotEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/maggot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MaggotEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/maggot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MaggotEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
