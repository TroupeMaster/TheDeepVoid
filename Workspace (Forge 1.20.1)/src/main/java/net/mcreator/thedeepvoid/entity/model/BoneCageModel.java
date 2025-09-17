package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BoneCageEntity;

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
