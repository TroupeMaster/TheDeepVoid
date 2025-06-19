package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.SmallFleshCubeEntity;

public class SmallFleshCubeModel extends GeoModel<SmallFleshCubeEntity> {
	@Override
	public ResourceLocation getAnimationResource(SmallFleshCubeEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/smallfleshcube.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SmallFleshCubeEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/smallfleshcube.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SmallFleshCubeEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
