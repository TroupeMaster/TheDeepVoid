package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.HeresyItem;

public class HeresyItemModel extends GeoModel<HeresyItem> {
	@Override
	public ResourceLocation getAnimationResource(HeresyItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/heresy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HeresyItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/heresy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HeresyItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/heresy.png");
	}
}
