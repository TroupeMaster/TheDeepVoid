package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.SummonedHiveFangsEntity;

public class SummonedHiveFangsModel extends GeoModel<SummonedHiveFangsEntity> {
	@Override
	public ResourceLocation getAnimationResource(SummonedHiveFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/hivefangs.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SummonedHiveFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/hivefangs.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SummonedHiveFangsEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
