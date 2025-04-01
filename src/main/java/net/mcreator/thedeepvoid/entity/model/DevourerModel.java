package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.DevourerEntity;

public class DevourerModel extends GeoModel<DevourerEntity> {
	@Override
	public ResourceLocation getAnimationResource(DevourerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/devourer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DevourerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/devourer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DevourerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
