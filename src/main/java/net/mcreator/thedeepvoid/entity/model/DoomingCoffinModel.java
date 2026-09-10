package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.DoomingCoffinEntity;

public class DoomingCoffinModel extends GeoModel<DoomingCoffinEntity> {
	@Override
	public ResourceLocation getAnimationResource(DoomingCoffinEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/coffinentity.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DoomingCoffinEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/coffinentity.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DoomingCoffinEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
