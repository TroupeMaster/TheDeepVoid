package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.FalseHydraArmEntity;

public class FalseHydraArmModel extends GeoModel<FalseHydraArmEntity> {
	@Override
	public ResourceLocation getAnimationResource(FalseHydraArmEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/falsehydraarm.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FalseHydraArmEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/falsehydraarm.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FalseHydraArmEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
