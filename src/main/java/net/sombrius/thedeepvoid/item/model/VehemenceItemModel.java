package net.sombrius.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.item.VehemenceItem;

import net.minecraft.resources.ResourceLocation;

public class VehemenceItemModel extends GeoModel<VehemenceItem> {
	@Override
	public ResourceLocation getAnimationResource(VehemenceItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/vehemence.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VehemenceItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/vehemence.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VehemenceItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/vehemence.png");
	}
}
