package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.SummonedDevourerEntity;

public class SummonedDevourerModel extends GeoModel<SummonedDevourerEntity> {
	@Override
	public ResourceLocation getAnimationResource(SummonedDevourerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/devourer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SummonedDevourerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/devourer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SummonedDevourerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
