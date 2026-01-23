package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.ApostleOfCatastropheEntity;

public class ApostleOfCatastropheModel extends GeoModel<ApostleOfCatastropheEntity> {
	@Override
	public ResourceLocation getAnimationResource(ApostleOfCatastropheEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/apostle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ApostleOfCatastropheEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/apostle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ApostleOfCatastropheEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
