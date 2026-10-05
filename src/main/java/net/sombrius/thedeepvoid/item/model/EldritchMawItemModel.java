package net.sombrius.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.item.EldritchMawItem;

import net.minecraft.resources.ResourceLocation;

public class EldritchMawItemModel extends GeoModel<EldritchMawItem> {
	@Override
	public ResourceLocation getAnimationResource(EldritchMawItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/eldritchmawarms.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EldritchMawItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/eldritchmawarms.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EldritchMawItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/eldritchmouth.png");
	}
}
