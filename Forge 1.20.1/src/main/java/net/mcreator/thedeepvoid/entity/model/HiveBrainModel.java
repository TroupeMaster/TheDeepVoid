package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.HiveBrainEntity;

public class HiveBrainModel extends GeoModel<HiveBrainEntity> {
	@Override
	public ResourceLocation getAnimationResource(HiveBrainEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/hive_brain.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HiveBrainEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/hive_brain.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HiveBrainEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
