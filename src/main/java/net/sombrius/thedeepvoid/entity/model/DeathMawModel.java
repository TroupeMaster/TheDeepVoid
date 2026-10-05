package net.sombrius.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.entity.DeathMawEntity;

import net.minecraft.resources.ResourceLocation;

public class DeathMawModel extends GeoModel<DeathMawEntity> {
	@Override
	public ResourceLocation getAnimationResource(DeathMawEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/deathmaw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DeathMawEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/deathmaw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DeathMawEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
