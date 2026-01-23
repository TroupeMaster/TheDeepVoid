package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.VoidbornEntity;

public class VoidbornModel extends GeoModel<VoidbornEntity> {
	@Override
	public ResourceLocation getAnimationResource(VoidbornEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/cavenightmare.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VoidbornEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/cavenightmare.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VoidbornEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
