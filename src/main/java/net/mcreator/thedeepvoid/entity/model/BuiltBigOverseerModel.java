package net.mcreator.thedeepvoid.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.entity.BuiltBigOverseerEntity;

public class BuiltBigOverseerModel extends GeoModel<BuiltBigOverseerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BuiltBigOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "animations/overseer3blocks.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BuiltBigOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "geo/overseer3blocks.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BuiltBigOverseerEntity entity) {
		return new ResourceLocation("the_deep_void", "textures/entities/" + entity.getTexture() + ".png");
	}

}
