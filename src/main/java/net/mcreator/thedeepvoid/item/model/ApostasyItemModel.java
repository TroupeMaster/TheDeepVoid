package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.ApostasyItem;

public class ApostasyItemModel extends GeoModel<ApostasyItem> {
	@Override
	public ResourceLocation getAnimationResource(ApostasyItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/apostasy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ApostasyItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/apostasy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ApostasyItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/apostasy.png");
	}
}
