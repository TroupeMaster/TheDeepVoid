package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.BoneCageEntity;

import net.minecraft.resources.ResourceLocation;

public class BoneCageModel extends GeoModel<BoneCageEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoneCageEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/bone_cage.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoneCageEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/bone_cage.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoneCageEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
