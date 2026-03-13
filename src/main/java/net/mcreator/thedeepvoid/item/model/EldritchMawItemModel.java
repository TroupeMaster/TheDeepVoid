package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.EldritchMawItem;

public class EldritchMawItemModel extends GeoModel<EldritchMawItem> {
	@Override
	public ResourceLocation getAnimationResource(EldritchMawItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/eldritchmouth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EldritchMawItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/eldritchmouth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EldritchMawItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/eldritchmouth.png");
	}
}
