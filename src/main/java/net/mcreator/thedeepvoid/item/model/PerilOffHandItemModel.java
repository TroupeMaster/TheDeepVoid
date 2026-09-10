package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.PerilOffHandItem;

public class PerilOffHandItemModel extends GeoModel<PerilOffHandItem> {
	@Override
	public ResourceLocation getAnimationResource(PerilOffHandItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/perilarms.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PerilOffHandItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/perilarms.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PerilOffHandItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/peril.png");
	}
}
