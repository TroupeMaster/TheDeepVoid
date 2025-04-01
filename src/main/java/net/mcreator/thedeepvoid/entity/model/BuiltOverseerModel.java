package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BuiltOverseerEntity;

public class BuiltOverseerModel extends GeoModel<BuiltOverseerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BuiltOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/overseer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BuiltOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/overseer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BuiltOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
