package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.ShadowEntity;

public class ShadowModel extends GeoModel<ShadowEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShadowEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/shadow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShadowEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/shadow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShadowEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
