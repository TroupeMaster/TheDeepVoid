package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.SawThrowerEntity;

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
