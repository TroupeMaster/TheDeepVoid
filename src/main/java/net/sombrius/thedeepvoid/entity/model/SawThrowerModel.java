package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.SawThrowerEntity;

import net.minecraft.resources.ResourceLocation;

public class SawThrowerModel extends GeoModel<SawThrowerEntity> {
	@Override
	public ResourceLocation getAnimationResource(SawThrowerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/saw_thrower.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SawThrowerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/saw_thrower.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SawThrowerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
