package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.FalseHydraSingingEntity;

import net.minecraft.resources.ResourceLocation;

public class FalseHydraSingingModel extends GeoModel<FalseHydraSingingEntity> {
	@Override
	public ResourceLocation getAnimationResource(FalseHydraSingingEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/falsehydra.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FalseHydraSingingEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/falsehydra.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FalseHydraSingingEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
