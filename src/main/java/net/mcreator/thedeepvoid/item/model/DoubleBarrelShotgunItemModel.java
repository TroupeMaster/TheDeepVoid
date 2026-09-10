package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.DoubleBarrelShotgunItem;

public class DoubleBarrelShotgunItemModel extends GeoModel<DoubleBarrelShotgunItem> {
	@Override
	public ResourceLocation getAnimationResource(DoubleBarrelShotgunItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/spitearms.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DoubleBarrelShotgunItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/spitearms.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DoubleBarrelShotgunItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/strife.png");
	}
}
