package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.DoomingTombstoneEntity;

public class DoomingTombstoneModel extends GeoModel<DoomingTombstoneEntity> {
	@Override
	public ResourceLocation getAnimationResource(DoomingTombstoneEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/tombstone.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DoomingTombstoneEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/tombstone.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DoomingTombstoneEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
