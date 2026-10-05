package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.GoreLurkerEntity;

import net.minecraft.resources.ResourceLocation;

public class GoreLurkerModel extends GeoModel<GoreLurkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoreLurkerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/harvestmen.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoreLurkerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/harvestmen.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoreLurkerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
