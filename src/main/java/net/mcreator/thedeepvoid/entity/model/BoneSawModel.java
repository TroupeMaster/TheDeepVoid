package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BoneSawEntity;

public class BoneSawModel extends GeoModel<BoneSawEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoneSawEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/bonesaw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoneSawEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/bonesaw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoneSawEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
