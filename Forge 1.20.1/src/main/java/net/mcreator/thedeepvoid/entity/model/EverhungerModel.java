package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.EverhungerEntity;

public class EverhungerModel extends GeoModel<EverhungerEntity> {
	@Override
	public ResourceLocation getAnimationResource(EverhungerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/everhunger.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EverhungerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/everhunger.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EverhungerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
