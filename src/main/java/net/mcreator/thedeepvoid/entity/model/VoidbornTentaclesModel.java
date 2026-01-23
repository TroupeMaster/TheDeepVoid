package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.VoidbornTentaclesEntity;

public class VoidbornTentaclesModel extends GeoModel<VoidbornTentaclesEntity> {
	@Override
	public ResourceLocation getAnimationResource(VoidbornTentaclesEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/voidborntentacles.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VoidbornTentaclesEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/voidborntentacles.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VoidbornTentaclesEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
