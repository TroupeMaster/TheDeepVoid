package net.mcreator.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thedeepvoid.item.MisanthropyItem;

public class MisanthropyItemModel extends GeoModel<MisanthropyItem> {
	@Override
	public ResourceLocation getAnimationResource(MisanthropyItem animatable) {
		return new ResourceLocation("the_deep_void", "animations/ichorrifle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MisanthropyItem animatable) {
		return new ResourceLocation("the_deep_void", "geo/ichorrifle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MisanthropyItem animatable) {
		return new ResourceLocation("the_deep_void", "textures/item/ichorrifle.png");
	}
}
