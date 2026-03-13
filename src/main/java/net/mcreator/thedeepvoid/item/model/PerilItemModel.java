package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.PerilItem;

public class PerilItemModel extends GeoModel<PerilItem> {
	@Override
	public ResourceLocation getAnimationResource(PerilItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/peril.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PerilItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/peril.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PerilItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/peril.png");
	}
}
