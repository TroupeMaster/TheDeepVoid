package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.FalseHydraEntity;

public class FalseHydraModel extends GeoModel<FalseHydraEntity> {
	@Override
	public ResourceLocation getAnimationResource(FalseHydraEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/falsehydra.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FalseHydraEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/falsehydra.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FalseHydraEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
