package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.PrisonGuardEntity;

public class PrisonGuardModel extends GeoModel<PrisonGuardEntity> {
	@Override
	public ResourceLocation getAnimationResource(PrisonGuardEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/prisonguard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrisonGuardEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/prisonguard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrisonGuardEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
