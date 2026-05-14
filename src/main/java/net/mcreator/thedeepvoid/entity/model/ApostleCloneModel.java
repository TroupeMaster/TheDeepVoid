package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.ApostleCloneEntity;

public class ApostleCloneModel extends GeoModel<ApostleCloneEntity> {
	@Override
	public ResourceLocation getAnimationResource(ApostleCloneEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/apostleofcatastrophe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ApostleCloneEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/apostleofcatastrophe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ApostleCloneEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
