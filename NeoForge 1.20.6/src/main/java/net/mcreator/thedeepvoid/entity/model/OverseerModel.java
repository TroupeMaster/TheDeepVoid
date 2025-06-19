package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.OverseerEntity;

public class OverseerModel extends GeoModel<OverseerEntity> {
	@Override
	public ResourceLocation getAnimationResource(OverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/overseer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/overseer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
