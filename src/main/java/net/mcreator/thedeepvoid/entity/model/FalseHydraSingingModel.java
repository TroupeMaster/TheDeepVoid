package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.FalseHydraSingingEntity;

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
