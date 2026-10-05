package net.sombrius.thedeepvoid.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.sombrius.thedeepvoid.item.FlyWingsItem;

import net.minecraft.resources.ResourceLocation;

public class FlyWingsModel extends GeoModel<FlyWingsItem> {
	@Override
	public ResourceLocation getAnimationResource(FlyWingsItem object) {
		return new ResourceLocation("the_deep_void", "animations/flywings.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlyWingsItem object) {
		return new ResourceLocation("the_deep_void", "geo/flywings.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlyWingsItem object) {
		return new ResourceLocation("the_deep_void", "textures/item/flywings.png");
	}
}
